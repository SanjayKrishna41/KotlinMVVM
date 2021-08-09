package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.R
import `in`.example.kotlinmvvm.databinding.ActivityLoginBinding
import `in`.example.kotlinmvvm.util.hide
import `in`.example.kotlinmvvm.util.show
import `in`.example.kotlinmvvm.util.toast
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        //get ViewModel to activity
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        // set viewModel to our binding view model
        binding.viewModel = viewModel

        //define auth listner to our viewModel
        viewModel.authListner = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }

    override fun onSFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}