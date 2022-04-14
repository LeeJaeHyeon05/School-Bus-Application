package com.example.schoolbusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class B1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b1)
        backBtn()



    }

    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}