package com.example.schoolbusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b2)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b1")

        backBtn()
    }

    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}
