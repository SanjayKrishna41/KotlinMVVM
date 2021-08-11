package `in`.example.kotlinmvvm.ui.auth

import `in`.example.kotlinmvvm.R
import `in`.example.kotlinmvvm.databinding.ActivitySignupBinding
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
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(),AuthListner, KodeinAware {


    override val kodein by kodein()

    private val factory : AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding
        val binding = DataBindingUtil.setContentView<ActivitySignupBinding>(this,R.layout.activity_signup)
        //get ViewModel to activity
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        // set viewModel to our binding view model
        binding.viewModel = viewModel
        //define auth listner to our viewModel
        viewModel.authListner = this

        viewModel.getLoggedInUser().observe(this, Observer { user->
            if (user!=null){
                // start home activity
                Intent(this, HomeActivity::class.java).also {
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