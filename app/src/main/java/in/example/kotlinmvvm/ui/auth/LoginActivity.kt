package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.R
import `in`.example.kotlinmvvm.data.db.AppDataBase
import `in`.example.kotlinmvvm.data.network.ApiService
import `in`.example.kotlinmvvm.data.repositories.UserRepository
import `in`.example.kotlinmvvm.databinding.ActivityLoginBinding
import `in`.example.kotlinmvvm.ui.home.HomeActivity
import `in`.example.kotlinmvvm.ui.model.UserModel
import `in`.example.kotlinmvvm.util.hide
import `in`.example.kotlinmvvm.util.show
import `in`.example.kotlinmvvm.util.snackBar
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //creating all the instances
        val api = ApiService()
        val db = AppDataBase(this)
        val repository = UserRepository(api,db)
        val factory = AuthViewModelFactory(repository)

        //binding
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this,R.layout.activity_login)
        //get ViewModel to activity
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        // set viewModel to our binding view model
        binding.viewModel = viewModel

        //define auth listner to our viewModel
        viewModel.authListner = this

        viewModel.getLoggedInUser().observe(this, Observer { user->
            if (user!=null){
                // start home activity
                Intent(this,HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user : UserModel) {
//        root_layout.snackBar("${user.email} is Logged in")
        progress_bar.hide()
    }

    override fun onSFailure(message: String) {
        progress_bar.hide()
        root_layout.snackBar(message)
    }
}