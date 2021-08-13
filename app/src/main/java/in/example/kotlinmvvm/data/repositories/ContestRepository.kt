package `in`.example.kotlinmvvm.data.repositories

import `in`.example.kotlinmvvm.data.network.ApiService
import `in`.example.kotlinmvvm.data.network.SafeApiRequest

class ContestRepository(
    private val api: ApiService
) : SafeApiRequest() {

//    private val contestDetails = MutableLiveData<>()

    suspend fun fetchContests(){
        val response = apiRequest {
            api.getContestList("17267")
        }
    }
}