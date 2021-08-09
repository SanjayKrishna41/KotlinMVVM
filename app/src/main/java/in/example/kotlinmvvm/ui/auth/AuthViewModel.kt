package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.data.repositories.UserRepository
import `in`.example.kotlinmvvm.ui.model.UserModel
import `in`.example.kotlinmvvm.util.ApiException
import `in`.example.kotlinmvvm.util.Coroutines
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

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
                    val loginResponse = UserRepository().userLogin(params)

                    if (loginResponse.status.equals("ok", ignoreCase = true)) {
                        authListner?.onSuccess(loginResponse.data!!)
                    } else {
                        authListner?.onSFailure(loginResponse.message.toString())
                    }
                } catch (e: ApiException) {
                    authListner?.onSFailure(e.message.toString())
                }
            }
        }
    }
}