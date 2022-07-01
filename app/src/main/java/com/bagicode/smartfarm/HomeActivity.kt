package com.bagicode.smartfarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bagicode.smartfarm.buttomnavigation.fragments.AccountFragment
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentHome = HomeFragment()
        val buttom_navigation_view : BottomNavigationView = findViewById(R.id.buttom_navigation)

        buttom_navigation_view.setOnNavigationItemSelectedListener(menuItemSelected)

        addFragment(fragmentHome)
    }

    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener {item->
        when (item.itemId) {
            R.id.home ->{
                val fragment = HomeFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.account ->{
                val fragment = AccountFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment (fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.layout_frame, fragment)
            .commit()
    }
}