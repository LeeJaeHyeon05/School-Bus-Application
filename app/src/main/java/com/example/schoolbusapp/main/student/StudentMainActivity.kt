package com.example.schoolbusapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.ActivityStudentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class StudentMainActivity : AppCompatActivity() {

    private lateinit var homeFragment: StudentHomeFragment
    private lateinit var chatFragment: StudentChatFragment

    private var mBinding: ActivityStudentMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStudentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnNav = binding.bottomNav
        btnNav.setOnNavigationItemSelectedListener (onBottomNavItemSelectedListener)

        homeFragment = StudentHomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()



    }
    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when (it.itemId) {
            R.id.menu_home -> {
                homeFragment = StudentHomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_chat -> {
                chatFragment = StudentChatFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, chatFragment).commit()
            }
        }
        true
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}