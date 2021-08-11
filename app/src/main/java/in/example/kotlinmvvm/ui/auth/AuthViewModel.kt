package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.data.repositories.UserRepository
import `in`.example.kotlinmvvm.ui.model.UserModel
import `in`.example.kotlinmvvm.util.ApiException
import `in`.example.kotlinmvvm.util.Coroutines
import `in`.example.kotlinmvvm.util.NoInternetException
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel(
    private val repository : UserRepository
) : ViewModel() {

    var email: String? = null
    var password: String? = null
    var name: String? = null
    var confirmPassword: String? = null
    var authListner: AuthListner? = null

    // function for login button click
    fun onLoginButtonClick(view: View) {
        //login call is started
        authListner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //display error message
            authListner?.onSFailure("All fields are mandatory")
        } else {
            Coroutines.main {
                try {
                    val params = UserModel(email!!, password!!)
                    val loginResponse = repository.userLogin(params)

                    if (loginResponse.status.equals("ok", ignoreCase = true)) {
                        authListner?.onSuccess(loginResponse.data!!)
                        // save user in database
                        repository.saveUser(params)
                        return@main
                    } else {
                        authListner?.onSFailure(loginResponse.message.toString())
                    }
                } catch (e: ApiException) {
                    authListner?.onSFailure(e.message.toString())
                } catch (e: NoInternetException) {
                    authListner?.onSFailure(e.message.toString())
                }
            }
        }
    }

    //function for signup button
    fun onSignButtonClick(view: View) {
        //login call is started
        authListner?.onStarted()

        if(name.isNullOrEmpty()){
            authListner?.onSFailure("Name is required")
            return
        }

        if (email.isNullOrEmpty()) {
            //display error message
            authListner?.onSFailure("email required")
            return
        }

        if (password.isNullOrEmpty()) {
            //display error message
            authListner?.onSFailure("Password required")
            return
        }

        if (confirmPassword.isNullOrEmpty()) {
            //display error message
            authListner?.onSFailure("Password required")
            return
        }

        if (confirmPassword != password) {
            //display error message
            authListner?.onSFailure("Password Mismatch")
            return
        }

        Coroutines.main {
            try {
                val params = UserModel(email!!, password!!)
                val loginResponse = repository.userLogin(params)

                if (loginResponse.status.equals("ok", ignoreCase = true)) {
                    authListner?.onSuccess(loginResponse.data!!)
                    // save user in database
                    repository.saveUser(params)
                    return@main
                } else {
                    authListner?.onSFailure(loginResponse.message.toString())
                }
            } catch (e: ApiException) {
                authListner?.onSFailure(e.message.toString())
            } catch (e: NoInternetException) {
                authListner?.onSFailure(e.message.toString())
            }
        }
    }

    // function to go to sign up screen
    fun onSignUp(view: View){
        Intent(view.context,SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    // function to go to sign in screen
    fun onSignIn(view: View){
        Intent(view.context,LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun getLoggedInUser() = repository.getUser()
}