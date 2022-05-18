package com.example.schoolbusapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b3)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b3")

        val masteriThaoDienA4StartButton = findViewById<Button>(R.id.masteriThaoDienA4StartButton)
        val masteriThaoDienA4StopButton = findViewById<Button>(R.id.masteriThaoDienA4StopButton)
        val theNassimGateStartButton = findViewById<Button>(R.id.theNassimGateStartButton)
        val theNassimGateStopButton = findViewById<Button>(R.id.theNassimGateStopButton)
        val estellaStartButton = findViewById<Button>(R.id.estellaStartButton)
        val estellaStopButton = findViewById<Button>(R.id.estellaStopButton)
        val imperiaStartButton = findViewById<Button>(R.id.imperiaStartButton)
        val imperiaStopButton = findViewById<Button>(R.id.imperiaStopButton)
        val lexingtonStartButton = findViewById<Button>(R.id.lexingtonStartButton)
        val lexingtonStopButton = findViewById<Button>(R.id.lexingtonStopButton)


        val startBtn = findViewById<Button>(R.id.startBus)
        val stopBtn = findViewById<Button>(R.id.stopBus)

        val busData = hashMapOf(
            "startStop" to "3호차 운행중",
            "masteriThaoDienA4" to "마스테리다오디엔",
            "theNassimGate" to "더 나심",
            "estella" to "에스텔라",
            "imperia" to "임페리아",
            "lexington" to "렉싱턴",
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
            busInfo.update("startStop", "3호차 운행 중지")
                .addOnSuccessListener {
                    Toast("성공")
                }
                .addOnCanceledListener {
                    Toast("실")
                }
            true
        }


        masteriThaoDienA4StartButton.setOnClickListener {
            busInfo.update("masteriThaoDienA4", "마스테리다오디엔 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        masteriThaoDienA4StartButton.setOnLongClickListener {
            busInfo.update("masteriThaoDienA4", "마스테리다오디엔 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "fail")
                }
            true
        }


        masteriThaoDienA4StopButton.setOnClickListener {
            busInfo.update("masteriThaoDienA4", "마스테리다오디엔 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        masteriThaoDienA4StopButton.setOnLongClickListener {
            busInfo.update("masteriThaoDienA4", "마스테리다오디엔 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        theNassimGateStartButton.setOnClickListener {
            busInfo.update("theNassimGate", "더 나심에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        theNassimGateStartButton.setOnLongClickListener {
            busInfo.update("theNassimGate", "더 나심 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        theNassimGateStopButton.setOnClickListener {
            busInfo.update("theNassimGate", "더 나심 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        theNassimGateStopButton.setOnLongClickListener {
            busInfo.update("theNassimGate", "더 나심 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        estellaStartButton.setOnClickListener {
            busInfo.update("estella", "에스텔라 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        estellaStartButton.setOnLongClickListener {
            busInfo.update("estella", "에스텔라 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        estellaStopButton.setOnClickListener {
            busInfo.update("estella", "에스텔라 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        estellaStopButton.setOnLongClickListener {
            busInfo.update("estella", "에스텔라 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        imperiaStartButton.setOnClickListener {
            busInfo.update("imperia", "임페리아 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        imperiaStartButton.setOnLongClickListener {
            busInfo.update("imperia", "임페리아 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        imperiaStopButton.setOnClickListener {
            busInfo.update("imperia", "임페리아 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        imperiaStopButton.setOnLongClickListener {
            busInfo.update("imperia", "임페리아 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        lexingtonStartButton.setOnClickListener {
            busInfo.update("lexington", "렉싱턴에 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        lexingtonStartButton.setOnLongClickListener {
            busInfo.update("lexington", "렉싱턴 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        lexingtonStopButton.setOnClickListener {
            busInfo.update("lexington", "렉싱턴에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        lexingtonStopButton.setOnLongClickListener {
            busInfo.update("lexington", "렉싱턴 지났습니다")
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun backBtn() {
        val backBtn = findViewById<Button>(R.id.backPressedButton)
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}