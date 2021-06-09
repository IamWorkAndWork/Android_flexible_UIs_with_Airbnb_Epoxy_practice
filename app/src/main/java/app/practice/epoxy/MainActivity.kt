package app.practice.epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import app.practice.epoxy.databinding.ActivityMainBinding
import app.practice.epoxy.example1.Example1Fragment
import app.practice.epoxy.example2.example2Fragment
import com.airbnb.epoxy.Carousel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), MenuFragment.MenuFragmentListener {

    private lateinit var binding: ActivityMainBinding

    val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
    }

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        binding.lifecycleOwner = this

//        val appBarConfiguration = AppBarConfiguration(
//            topLevelDestinationIds = setOf(
//                R.id.fragmentMenu,
//                R.id.fragmentExample1,
//                R.id.fragmentExample2
//            ),
//            fallbackOnNavigateUpListener = ::onSupportNavigateUp
//        )

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolBar.setupWithNavController(navController, appBarConfiguration)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.frameContent, MenuFragment.newInstance("",""))
//            .addToBackStack(null)
//            .commitAllowingStateLoss()
    }

    override fun changeFragment(pos: Int) {

        val direction = when (pos) {
            1 -> {
                MenuFragmentDirections.actionFragmentMenuToFragmentExample1()
            }
            2 -> {
                MenuFragmentDirections.actionFragmentMenuToFragmentExample2()
            }
            else ->{
                MenuFragmentDirections.actionFragmentMenuToFragmentExample3()
            }
        }

        navController.navigate(direction)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.frameContent, direction)
//            .addToBackStack(null)
//            .commitAllowingStateLoss()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
                || super.onSupportNavigateUp();
    }


}