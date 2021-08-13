package `in`.example.kotlinmvvm.ui.home.contest

import `in`.example.kotlinmvvm.data.repositories.ContestRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContestViewModelFactory(
    private val repository: ContestRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContestViewModel(repository) as T
    }
}