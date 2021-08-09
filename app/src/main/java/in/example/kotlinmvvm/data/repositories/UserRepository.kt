package `in`.example.kotlinmvvm.data.repositories

import `in`.example.kotlinmvvm.data.network.ApiService
import `in`.example.kotlinmvvm.data.network.SafeApiRequest
import `in`.example.kotlinmvvm.ui.model.SingleResponse
import `in`.example.kotlinmvvm.ui.model.UserModel

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(user: UserModel): SingleResponse<UserModel>{
        return apiRequest {
            ApiService().userLogin(user)
        }
    }
}