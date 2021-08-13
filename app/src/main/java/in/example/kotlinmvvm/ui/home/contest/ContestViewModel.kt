package `in`.example.kotlinmvvm.ui.home.contest

import `in`.example.kotlinmvvm.data.repositories.ContestRepository
import `in`.example.kotlinmvvm.util.lazyDeferred
import androidx.lifecycle.ViewModel

class ContestViewModel(
    repository: ContestRepository
) : ViewModel() {

    val contest by lazyDeferred {
        repository.fetchContests()
    }

}