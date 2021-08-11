package `in`.example.kotlinmvvm.data.repositories

import `in`.example.kotlinmvvm.data.db.AppDataBase
import `in`.example.kotlinmvvm.data.network.ApiService
import `in`.example.kotlinmvvm.data.network.SafeApiRequest
import `in`.example.kotlinmvvm.ui.model.SingleResponse
import `in`.example.kotlinmvvm.ui.model.UserModel

class UserRepository(
    private val api:ApiService,
    private val db : AppDataBase
) : SafeApiRequest() {

    suspend fun userLogin(user: UserModel): SingleResponse<UserModel>{
        return apiRequest {
            api.userLogin(user)
        }
    }

    suspend fun saveUser(user: UserModel) = db.getUserDao().insert(user)

    fun getUser() = db.getUserDao().getUser()
}