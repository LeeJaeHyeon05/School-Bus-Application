package com.example.schoolbusapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B1Activity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("bus")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b1)
        backBtn()

        val db = Firebase.firestore


        val cantavilStartButton = findViewById<Button>(R.id.cantavilStartButton)
        val cantavilStopButton = findViewById<Button>(R.id.cantavilStopButton)
        val ParkStartButton = findViewById<Button>(R.id.ParkStartButton)
        val ParkStopButton = findViewById<Button>(R.id.ParkStopButton)
        val LandmarkStartButton = findViewById<Button>(R.id.LandmarkStartButton)
        val LandmarkStopButton = findViewById<Button>(R.id.LandmarkStopButton)
        val landmarkPlusStartButton = findViewById<Button>(R.id.landmarkPlusStartButton)
        val landmarkPlusStopButton = findViewById<Button>(R.id.landmarkPlusStopButton)
        val landmark5StartButton = findViewById<Button>(R.id.landmark5StartButton)
        val landmark5StopButton = findViewById<Button>(R.id.landmark5StopButton)


        cantavilStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "캔타빌 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        cantavilStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "캔타빌에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }

        ParkStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "파크 7에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        ParkStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "파크 7에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        LandmarkStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "랜드마크에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        LandmarkStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "랜드마크에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }

        landmarkPlusStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "랜드마크 플러스에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        landmarkPlusStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "랜드마크 플러스에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }

        landmark5StartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "랜드마크5에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        landmark5StopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("cantavil", "랜드마크5에 도착 했습니다")
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