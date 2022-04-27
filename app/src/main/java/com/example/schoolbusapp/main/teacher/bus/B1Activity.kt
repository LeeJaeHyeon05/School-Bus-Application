package com.example.schoolbusapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B1Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b1)
        backBtn()

        val db = Firebase.firestore


        val cantavilStartButton = findViewById<Button>(R.id.cantavilStartButton)
        val ParkStartButton = findViewById<Button>(R.id.ParkStartButton)
        val LandmarkStartButton = findViewById<Button>(R.id.LandmarkStartButton)
        val landmarkPlusStartButton = findViewById<Button>(R.id.landmarkPlusStartButton)
        val landmark5StartButton = findViewById<Button>(R.id.landmark5StartButton)

        cantavilStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", true)
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }





    }

    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}