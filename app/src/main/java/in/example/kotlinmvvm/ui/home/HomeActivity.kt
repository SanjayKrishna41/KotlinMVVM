package `in`.example.kotlinmvvm.ui.home

import `in`.example.kotlinmvvm.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //set toolbar for the activity
        setSupportActionBar(toolbar)
        // for navigation
        val navController = Navigation.findNavController(this,R.id.fragment)
        // set up nav UI
        NavigationUI.setupWithNavController(nav_view,navController)
        // setup action bar with our nav controller
        NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout)
    }

    // set up arrow to navigate back to the screens
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.fragment),drawer_layout)
    }
}