package com.example.schoolbusapp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.ActivityIntroBinding
import com.example.schoolbusapp.databinding.ActivityStudentLoginBinding
import java.text.SimpleDateFormat

class StudentLoginActivity : AppCompatActivity() {

    private var mBinding : ActivityStudentLoginBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStudentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentTime : Long = System.currentTimeMillis()

        //날짜
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        binding.studentLoginDateTextView.text = dateFormat.format(currentTime)
        //시간
        val timeFormat = SimpleDateFormat("HH시 : mm분")
        binding.studentLoginTimeTextView.text = timeFormat.format(currentTime)




    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}