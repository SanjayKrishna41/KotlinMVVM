package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.ui.model.UserModel

interface AuthListner {

    // when the api call is started
    fun onStarted()
    // if login is success
    fun onSuccess(loginResponse: UserModel)
    //if login is failure
    fun onSFailure(message: String)
}