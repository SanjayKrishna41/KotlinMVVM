package `in`.example.kotlinmvvm.data.repositories

import `in`.example.kotlinmvvm.data.network.ApiService
import `in`.example.kotlinmvvm.ui.model.SingleResponse
import `in`.example.kotlinmvvm.ui.model.UserModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(user: UserModel): LiveData<String> {
        val loginResponse = MutableLiveData<String>()
        ApiService().userLogin(user)
            .enqueue(object : Callback<SingleResponse<UserModel>> {
                override fun onResponse(
                    call: Call<SingleResponse<UserModel>>,
                    response: Response<SingleResponse<UserModel>>
                ) {
                    val userResponse = response.body()?.data

                    loginResponse.value = "Welcome ${userResponse?.email}"
                }
                override fun onFailure(call: Call<SingleResponse<UserModel>>, t: Throwable) {
                    loginResponse.value = t.message
                }
            })
        return loginResponse
    }
}