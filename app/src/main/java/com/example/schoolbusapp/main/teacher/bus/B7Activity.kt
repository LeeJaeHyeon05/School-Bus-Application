package com.example.schoolbusapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b7)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b7")

        val hungPhucRiversideStartBucksStartButton = findViewById<Button>(R.id.hưngPhúcRiversideStarbucksStartButton)
        val hungPhucRiversideStartBucksStopButton = findViewById<Button>(R.id.hưngPhúcRiversideStarbucksStopButton)
        val namPhucBaeMartStartButton = findViewById<Button>(R.id.namPhúcBaeMartStartButton)
        val namPhucBaeMartStopButton = findViewById<Button>(R.id.namPhúcBaeMartStopButton)
        val midtownKMartBlockM6StartButton = findViewById<Button>(R.id.midtownKMartBlockM6StartButton)
        val midtownKMartBlockM6StopButton = findViewById<Button>(R.id.midtownKMartBlockM6StopButton)
        val rivieraPointHighlandsCoffeeStartButton = findViewById<Button>(R.id.rivieraPointHighlandsCoffeeStartButton)
        val rivieraPointHighlandsCoffeeStopButton = findViewById<Button>(R.id.rivieraPointHighlandsCoffeeStopButton)

        val startBtn = findViewById<Button>(R.id.startBus)
        val stopBtn = findViewById<Button>(R.id.stopBus)

        val busData = hashMapOf(
            "startStop" to "6호차 운행중",

            "hưngPhúcRiversideStarbucks" to "흥푹리버사이드 (스타벅스)",
            "namPhúcBaeMart " to "남푹(배마트)",
            "midtownK-MartBlockM6" to "미드타운",
            "rivieraPointHighlandsCoffee" to "리베라포인트",
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
            busInfo.update("startStop", "7호차 운행 중지")
                .addOnSuccessListener {
                    Toast("성공")
                }
                .addOnCanceledListener {
                    Toast("실")
                }
            true
        }


        hungPhucRiversideStartBucksStartButton.setOnClickListener {
            busInfo.update("hưngPhúcRiversideStarbucks", "흥푹리버사이드 (스타벅스) 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        hungPhucRiversideStartBucksStartButton.setOnLongClickListener {
            busInfo.update("hưngPhúcRiversideStarbucks", "흥푹리버사이드 (스타벅스) 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "fail")
                }
            true
        }


        hungPhucRiversideStartBucksStopButton.setOnClickListener {
            busInfo.update("hưngPhúcRiversideStarbucks", "흥푹리버사이드 (스타벅스) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        hungPhucRiversideStartBucksStopButton.setOnLongClickListener {
            busInfo.update("hưngPhúcRiversideStarbucks", "흥푹리버사이드 (스타벅스) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        namPhucBaeMartStartButton.setOnClickListener {
            busInfo.update("namPhúcBaeMart ", "남푹(배마트) 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        namPhucBaeMartStartButton.setOnLongClickListener {
            busInfo.update("namPhúcBaeMart", "남푹(배마트) 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        namPhucBaeMartStopButton.setOnClickListener {
            busInfo.update("namPhúcBaeMart", "남푹(배마트) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        namPhucBaeMartStopButton.setOnLongClickListener {
            busInfo.update("namPhúcBaeMart", "남푹(배마트) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        midtownKMartBlockM6StartButton.setOnClickListener {
            busInfo.update("midtownK-MartBlockM6", "미드타운 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        midtownKMartBlockM6StartButton.setOnLongClickListener {
            busInfo.update("midtownK-MartBlockM6", "미드타운 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        midtownKMartBlockM6StopButton.setOnClickListener {
            busInfo.update("midtownK-MartBlockM6", "미드타운 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        midtownKMartBlockM6StopButton.setOnLongClickListener {
            busInfo.update("midtownK-MartBlockM6", "미드타운 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        rivieraPointHighlandsCoffeeStartButton.setOnClickListener {
            busInfo.update("rivieraPointHighlandsCoffee", "리베라포인트 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        rivieraPointHighlandsCoffeeStartButton.setOnLongClickListener {
            busInfo.update("rivieraPointHighlandsCoffee", "리베라포인트 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        rivieraPointHighlandsCoffeeStopButton.setOnClickListener {
            busInfo.update("rivieraPointHighlandsCoffee", "리베라포인트 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        rivieraPointHighlandsCoffeeStopButton.setOnLongClickListener {
            busInfo.update("rivieraPointHighlandsCoffee", "리베라포인트 지났습니다")
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