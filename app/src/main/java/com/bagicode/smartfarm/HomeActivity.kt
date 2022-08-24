package com.bagicode.smartfarm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bagicode.smartfarm.buttomnavigation.fragments.AccountFragment
import com.bagicode.smartfarm.buttomnavigation.fragments.HelpFragment
import com.bagicode.smartfarm.buttomnavigation.fragments.HistoryFragment
import com.bagicode.smartfarm.buttomnavigation.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(HistoryFragment())

        val fragmentHome = HomeFragment()
        //membuat buttomnavigation
        val buttom_navigation_view : BottomNavigationView = findViewById(R.id.buttom_navigation)

        buttom_navigation_view.setOnNavigationItemSelectedListener(menuItemSelected)
        //menambahkan fragment home
        addFragment(fragmentHome)

        val intent = Intent(this@HomeActivity, MyNotif::class.java)
        startService(intent)
    }

    private fun replaceFragment(historyFragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_frame, historyFragment)
        fragmentTransaction.commit()
    }


    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener {item->
        when (item.itemId) {
            //untuk membuat fragment help
            R.id.help ->{
                val fragment = HelpFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            //untuk membuat fragment home
            R.id.home ->{
                val fragment = HomeFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            //untuk membuat fragment history
            R.id.history ->{
                val fragment = HistoryFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            //untuk membuat fragment account
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