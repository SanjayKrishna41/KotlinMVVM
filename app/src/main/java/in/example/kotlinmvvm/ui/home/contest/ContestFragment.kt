package `in`.example.kotlinmvvm.ui.home.contest

import `in`.example.kotlinmvvm.R
import `in`.example.kotlinmvvm.util.Coroutines
import `in`.example.kotlinmvvm.util.toast
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ContestFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: ContestViewModelFactory by instance()

    private lateinit var viewModel: ContestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contest_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContestViewModel::class.java)

        Coroutines.main {
            val contest = viewModel.contest.await()
            context?.toast(contest.toString())
        }
    }

}