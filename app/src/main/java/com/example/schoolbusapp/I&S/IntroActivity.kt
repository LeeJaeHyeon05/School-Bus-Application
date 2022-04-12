package com.example.schoolbusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.schoolbusapp.databinding.ActivityIntroBinding
import com.example.schoolbusapp.login.StudentLoginActivity
import com.example.schoolbusapp.login.TeacherLoginActivity

class IntroActivity : AppCompatActivity() {

    private var mBinding : ActivityIntroBinding? = null
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.studentImageView.setOnClickListener {
            startActivity(Intent(this, StudentLoginActivity::class.java))
        }
        binding.teacherImageView.setOnClickListener {
            startActivity(Intent(this, TeacherLoginActivity::class.java))
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}