package com.example.schoolbusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b7)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b7")
        backBtn()
    }
    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}