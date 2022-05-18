package com.example.schoolbusapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b6)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b6")

        val skyGarden3CircleKStartButton = findViewById<Button>(R.id.skyGarden3CircleKStartButton)
        val skyGarden3CircleKStopButton = findViewById<Button>(R.id.skyGarden3CircleKStopButton)
        val scenicValley2ParisBaguetteStartButton = findViewById<Button>(R.id.scenicValley2ParisBaguetteStartButton)
        val scenicValley2ParisBaguetteStopButton = findViewById<Button>(R.id.scenicValley2ParisBaguetteStopButton)
        val scenicValley1Gate1StartButton = findViewById<Button>(R.id.scenicValley1Gate1StartButton)
        val scenicValley1Gate1StopButton = findViewById<Button>(R.id.scenicValley1Gate1StopButton)
        val greenValleyStartButton = findViewById<Button>(R.id.greenValleyStartButton)
        val greenValleyStopButton = findViewById<Button>(R.id.greenValleyStopButton)

        val startBtn = findViewById<Button>(R.id.startBus)
        val stopBtn = findViewById<Button>(R.id.stopBus)

        val busData = hashMapOf(
            "startStop" to "6호차 운행중",

            "skyGarden3CircleK" to "스카이가든3",
            "scenicValley2ParisBaguette" to "시닉밸리2",
            "scenicValley1" to "시닉밸리1",
            "greenValley" to "그린밸리",
        )

        startBtn.setOnLongClickListener {
            busInfo.update(busData as Map<String, Any>)
                .addOnSuccessListener {
                    Toast("버튼 성공")
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Toast("실패 다시해주세요")
                    Log.d(ContentValues.TAG, "실패")
                }
            true
        }
        stopBtn.setOnLongClickListener {
            busInfo.update("startStop", "6호차 운행 중지")
                .addOnSuccessListener {
                    Toast("성공")
                }
                .addOnCanceledListener {
                    Toast("실")
                }
            true
        }


        skyGarden3CircleKStartButton.setOnClickListener {
            busInfo.update("skyGarden3CircleK", "스카이가든3 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        skyGarden3CircleKStartButton.setOnLongClickListener {
            busInfo.update("skyGarden3CircleK", "스카이가든3 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "fail")
                }
            true
        }


        skyGarden3CircleKStopButton.setOnClickListener {
            busInfo.update("skyGarden3CircleK", "스카이가든3 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        skyGarden3CircleKStopButton.setOnLongClickListener {
            busInfo.update("skyGarden3CircleK", "스카이가든3 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        scenicValley2ParisBaguetteStartButton.setOnClickListener {
            busInfo.update("scenicValley2ParisBaguette ", "시닉밸리2 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        scenicValley2ParisBaguetteStartButton.setOnLongClickListener {
            busInfo.update("scenicValley2ParisBaguette", "시닉밸리2 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        scenicValley2ParisBaguetteStopButton.setOnClickListener {
            busInfo.update("scenicValley2ParisBaguette", "시닉밸리2 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        scenicValley2ParisBaguetteStopButton.setOnLongClickListener {
            busInfo.update("scenicValley2ParisBaguette", "시닉밸리2 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        scenicValley1Gate1StartButton.setOnClickListener {
            busInfo.update("scenicValley1", "시닉밸리1 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        scenicValley1Gate1StartButton.setOnLongClickListener {
            busInfo.update("scenicValley1", "시닉밸리1 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        scenicValley1Gate1StopButton.setOnClickListener {
            busInfo.update("scenicValley1", "시닉밸리1 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        scenicValley1Gate1StopButton.setOnLongClickListener {
            busInfo.update("scenicValley1", "시닉밸리1 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        greenValleyStartButton.setOnClickListener {
            busInfo.update("greenValley", "그린밸리 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        greenValleyStartButton.setOnLongClickListener {
            busInfo.update("greenValley", "그린밸리 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        greenValleyStopButton.setOnClickListener {
            busInfo.update("greenValley", "그린밸리 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        greenValleyStopButton.setOnLongClickListener {
            busInfo.update("greenValley", "그린밸리 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        backBtn()
    }
    private fun Toast(message : String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}