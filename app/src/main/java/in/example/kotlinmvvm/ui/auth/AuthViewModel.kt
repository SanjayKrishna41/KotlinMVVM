package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.data.repositories.UserRepository
import `in`.example.kotlinmvvm.ui.model.UserModel
import `in`.example.kotlinmvvm.util.ApiException
import `in`.example.kotlinmvvm.util.Coroutines
import `in`.example.kotlinmvvm.util.NoInternetException
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel(
    private val repository : UserRepository
) : ViewModel() {

    var email: String? = null
    var password: String? = null
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

    fun getLoggedInUser() = repository.getUser()
}