package com.example.schoolbusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schoolbusapp.databinding.ActivityStudentMainBinding
import com.example.schoolbusapp.databinding.ActivityTeacherMainBinding
import com.example.schoolbusapp.main.StudentChatFragment
import com.example.schoolbusapp.main.StudentHomeFragment
import com.example.schoolbusapp.main.teacher.TeacherHomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TeacherMainActivity : AppCompatActivity() {


    private lateinit var homeFragment: TeacherHomeFragment

    private var mBinding: ActivityTeacherMainBinding? = null
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTeacherMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnNav = binding.bottomNav
        btnNav.setOnNavigationItemSelectedListener (onBottomNavItemSelectedListener)

        homeFragment = TeacherHomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()


    }
    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when (it.itemId) {
            R.id.menu_home -> {
                homeFragment = TeacherHomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
        }
        true
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}