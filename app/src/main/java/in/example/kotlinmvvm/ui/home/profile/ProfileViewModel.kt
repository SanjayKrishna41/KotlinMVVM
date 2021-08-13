package `in`.example.kotlinmvvm.ui.home.profile

import `in`.example.kotlinmvvm.data.repositories.UserRepository
import androidx.lifecycle.ViewModel

class ProfileViewModel(repository: UserRepository) : ViewModel() {

    val user = repository.getUser()

}