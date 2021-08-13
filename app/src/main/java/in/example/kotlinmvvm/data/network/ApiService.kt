package `in`.example.kotlinmvvm.data.network

import `in`.example.kotlinmvvm.ui.model.ContestResponse
import `in`.example.kotlinmvvm.ui.model.SingleResponse
import `in`.example.kotlinmvvm.ui.model.UserModel
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("user/emaillogin")
    suspend fun userLogin(
        @Body params : UserModel
    ) : Response<SingleResponse<UserModel>>

    @POST("user/emaillogin")
    suspend fun userSignUp(
        @Body params : UserModel
    ) : Response<SingleResponse<UserModel>>

    @GET("ontest/contestlist/{userid}")
    fun getContestList(
        @Path(value = "userid", encoded = true) filter: String?
    ): Response<SingleResponse<ContestResponse>>

    companion object{
        operator fun invoke(
            networkConnectionInterceptor : NetworkConnectionInterceptor
        ) : ApiService{
            // create okhttp client for network connection
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://103.86.177.104:8100/bysos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}