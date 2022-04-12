package com.example.schoolbusapp.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.ActivityIntroBinding
import com.example.schoolbusapp.databinding.ActivityStudentLoginBinding
import com.example.schoolbusapp.databinding.FragmentHomeBinding
import com.example.schoolbusapp.main.HomeFragment
import com.example.schoolbusapp.main.MainActivity
import java.text.SimpleDateFormat

class StudentLoginActivity : AppCompatActivity() {

    private var mBinding : ActivityStudentLoginBinding? = null
    private val binding get() = mBinding!!

    private val IP = IdPassWord("student", "kgs123")


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


        initLogin()

    }

    private fun initLogin() {
        val idText = binding.IdEditText
        val passwordText = binding.passwordEditText
        val loginButton = binding.loginStudentButton

        loginButton.setOnClickListener {
            //input 값을 id 와 password 둘다 설정해준다
            val inputLogin = idText.text?.trim().toString()
            val inputPassword = passwordText.text?.trim().toString()

            // 간단 로그인을 위한 메인
            //만약 아이디와 비번이 인풋과 같으면 intent를 활용해 test 페이지를 보여준다
            if (inputLogin == IP.id && inputPassword == IP.password) {
                startActivity(Intent(this, MainActivity::class.java ))
                //만약 안 같고 비어있으면 이 구문을 실행
            } else {
                if (inputLogin.isNullOrEmpty() && inputPassword.isNullOrEmpty()) {
                    Toast.makeText(this, "아이디와 비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show()
                } //id 가 틀리면 실행
                else if(inputLogin!=IP.id) {
                    Toast.makeText(this, "존재하지 않는 아이디 입니다.", Toast.LENGTH_SHORT).show()

                } else { //나머지를 통과하고 비번이 틀리면 이것을 실행
                    Toast.makeText(this, "비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}