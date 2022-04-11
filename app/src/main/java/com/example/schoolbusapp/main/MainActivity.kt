package com.example.schoolbusapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var chatFragment: ChatFragment

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}