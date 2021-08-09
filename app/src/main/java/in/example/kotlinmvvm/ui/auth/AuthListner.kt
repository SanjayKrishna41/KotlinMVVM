package `in`.example.kotlinmvvm.ui.auth

import androidx.lifecycle.LiveData

interface AuthListner {

    // when the api call is started
    fun onStarted()
    // if login is success
    fun onSuccess(loginResponse: LiveData<String>)
    //if login is failure
    fun onSFailure(message: String)
}