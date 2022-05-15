package com.example.schoolbusapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b2)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b2")

        val sapphiraSaigonPearlTowerStartButton = findViewById<Button>(R.id.sapphiraSaigonPearlTowerStartButton)
        val sapphiraSaigonPearlTowerStopButton = findViewById<Button>(R.id.sapphiraSaigonPearlTowerStopButton)
        val newcity1StartButton = findViewById<Button>(R.id.newcity1StartButton)
        val newcity1StopButton = findViewById<Button>(R.id.newcity1StopButton)
        val newcity2StartButton = findViewById<Button>(R.id.newcity2StartButton)
        val newcity2StopButton = findViewById<Button>(R.id.newcity2StopButton)
        val theSunAvenueSAVSubgateStartButton = findViewById<Button>(R.id.theSunAvenueSAVSubgateStartButton)
        val theSunAvenueSAVSubgateStopButton = findViewById<Button>(R.id.theSunAvenueSAVSubgateStopButton)

        val startBtn = findViewById<Button>(R.id.startBus)
        val stopBtn = findViewById<Button>(R.id.stopBus)

        val busData = hashMapOf(
            "startStop" to "2호차 운행중",
            "sapphiraSaigonPearlTower" to "사파이라사이공",
            "newCity,ThuThiem1 " to "뉴시티1",
            "newCity,ThuThiem2" to "뉴시티2",
            "theSunAvenueSAV" to "더 선애비뉴",
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
            busInfo.update("startStop", "2호차 운행 중지")
                .addOnSuccessListener {
                    Toast("성공")
                }
                .addOnCanceledListener {
                    Toast("실")
                }
            true
        }


        sapphiraSaigonPearlTowerStartButton.setOnClickListener {
            busInfo.update("sapphiraSaigonPearlTower", "사피라사이공타워 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        sapphiraSaigonPearlTowerStartButton.setOnLongClickListener {
            busInfo.update("sapphiraSaigonPearlTower", "사피라사이공타워 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "fail")
                }
            true
        }


        sapphiraSaigonPearlTowerStopButton.setOnClickListener {
            busInfo.update("sapphiraSaigonPearlTower", "사피라사이공타워에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        sapphiraSaigonPearlTowerStopButton.setOnLongClickListener {
            busInfo.update("sapphiraSaigonPearlTower", "사피라사이공타워 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        newcity1StartButton.setOnClickListener {
            busInfo.update("newCity,ThuThiem1 ", "뉴시티 1에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        newcity1StartButton.setOnLongClickListener {
            busInfo.update("newCity,ThuThiem1", "뉴시티 1 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        newcity1StopButton.setOnClickListener {
            busInfo.update("newCity,ThuThiem1", "뉴시티 1에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        newcity1StopButton.setOnLongClickListener {
            busInfo.update("newCity,ThuThiem1", "뉴시티 1 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        newcity2StartButton.setOnClickListener {
            busInfo.update("newCity,ThuThiem2", "뉴시티 2에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        newcity2StartButton.setOnLongClickListener {
            busInfo.update("newCity,ThuThiem2", "뉴시티 2 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        newcity2StopButton.setOnClickListener {
            busInfo.update("newCity,ThuThiem2", "뉴시티 2에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        newcity2StopButton.setOnLongClickListener {
            busInfo.update("newCity,ThuThiem2", "뉴시티 2 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        theSunAvenueSAVSubgateStartButton.setOnClickListener {
            busInfo.update("theSunAvenueSAV", "더 선애비뉴에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        theSunAvenueSAVSubgateStartButton.setOnLongClickListener {
            busInfo.update("theSunAvenueSAV", "더 선애비뉴 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        theSunAvenueSAVSubgateStopButton.setOnClickListener {
            busInfo.update("theSunAvenueSAV", "더 선애비뉴에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        theSunAvenueSAVSubgateStopButton.setOnLongClickListener {
            busInfo.update("theSunAvenueSAV", "더 선애비뉴 지났습니다")
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


    private fun Toast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }


}

