package `in`.example.kotlinmvvm.data.network

import `in`.example.kotlinmvvm.ui.model.SingleResponse
import `in`.example.kotlinmvvm.ui.model.UserModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("user/emaillogin")
    fun userLogin(
        @Body params : UserModel
    ) : Call<SingleResponse<UserModel>>


    companion object{
        operator fun invoke() : ApiService{
            return Retrofit.Builder()
                .baseUrl("http://103.86.177.104:8100/bysos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}