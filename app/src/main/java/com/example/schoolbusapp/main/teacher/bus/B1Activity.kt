package com.example.schoolbusapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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

        val busInfo = db.collection("busInfo").document("b1")

        val cantavilStartButton = findViewById<Button>(R.id.cantavilStartButton)
        val cantavilStopButton = findViewById<Button>(R.id.cantavilStopButton)
        val parkStartButton = findViewById<Button>(R.id.ParkStartButton)
        val ParkStopButton = findViewById<Button>(R.id.ParkStopButton)
        val LandmarkStartButton = findViewById<Button>(R.id.LandmarkStartButton)
        val LandmarkStopButton = findViewById<Button>(R.id.LandmarkStopButton)
        val landmarkPlusStartButton = findViewById<Button>(R.id.landmarkPlusStartButton)
        val landmarkPlusStopButton = findViewById<Button>(R.id.landmarkPlusStopButton)
        val landmark5StartButton = findViewById<Button>(R.id.landmark5StartButton)
        val landmark5StopButton = findViewById<Button>(R.id.landmark5StopButton)


        cantavilStartButton.setOnClickListener {
            busInfo.update("cantavil", "캔타빌 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        cantavilStartButton.setOnLongClickListener {
            busInfo.update("cantavil", "캔타빌 도착 5분전")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(TAG, "fail")
                }
            true
        }


        cantavilStopButton.setOnClickListener {
            busInfo.update("cantavil", "캔타빌에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        cantavilStopButton.setOnLongClickListener {
            busInfo.update("cantavil", "캔타빌 이미 지남")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }

        parkStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmark1", "파크 7에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        parkStartButton.setOnLongClickListener {
            busInfo.update("park7", "파크 7 도착 5분전")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }
        ParkStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("park7", "파크 7에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        ParkStopButton.setOnLongClickListener {
            busInfo.update("park7", "파크7 이미 지났습니다")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }
        LandmarkStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmark1", "랜드마크에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        LandmarkStartButton.setOnLongClickListener {
            busInfo.update("landmark1", "랜드마크 도착 5분 전")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }
        LandmarkStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmark1", "랜드마크에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        LandmarkStopButton.setOnLongClickListener {
            busInfo.update("landmark1", "랜드마크 도착 5분 전")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }

        landmarkPlusStartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmarkPlus", "랜드마크 플러스에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        landmarkPlusStartButton.setOnLongClickListener {
            busInfo.update("landmarkPlus", "랜드마크 플러스 도착 5분 전")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }
        landmarkPlusStopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmarkPlus", "랜드마크 플러스에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        landmarkPlusStopButton.setOnLongClickListener {
            busInfo.update("landmarkPlus", "랜드마크 플러스 지났습니다")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }

        landmark5StartButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmark5", "랜드마크5에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        landmark5StartButton.setOnLongClickListener {
            busInfo.update("landmark5", "랜드마크 5 도착 5분 전")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }
        landmark5StopButton.setOnClickListener {
            val bus1Info = db.collection("busInfo").document("b1")
            bus1Info.update("landmark5", "랜드마크5에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(TAG, "실패")
                }
        }
        landmark5StopButton.setOnLongClickListener {
            busInfo.update("landmark5", "랜드마크 플러스 이미 지났습니다")
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 성공", Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    Toast.makeText(this, "버튼 실패 다시 해주세요", Toast.LENGTH_SHORT).show()
                }
            true
        }






    }
    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}