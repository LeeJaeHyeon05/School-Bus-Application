package com.example.schoolbusapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b5)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b5")

        val grandViewCStartButton = findViewById<Button>(R.id.grandViewCStartButton)
        val grandViewCStopButton = findViewById<Button>(R.id.grandViewCStopButton)
        val grandViewAStartButton = findViewById<Button>(R.id.grandViewAStartButton)
        val grandViewAStopButton = findViewById<Button>(R.id.grandViewAStopButton)
        val myPhucStartButton = findViewById<Button>(R.id.mỹPhúcStartButton)
        val myPhucStopButton = findViewById<Button>(R.id.mỹPhúcStopButton)
        val lyLongTuongStartButton = findViewById<Button>(R.id.lýLongTườngStartButton)
        val lyLongTuongStopButton = findViewById<Button>(R.id.lýLongTườngStopButton)
        val myPhatSopanDonpanStartButton = findViewById<Button>(R.id.mỹphátSopanDonpanStartButton)
        val myPhatSopanDonpanStopButton = findViewById<Button>(R.id.mỹphátSopanDonpanStopButton)
        val myDucDominoPizzaStartButton = findViewById<Button>(R.id.mỹĐứcDominoPizzaStartButton)
        val myDucDominoPizzaStopButton = findViewById<Button>(R.id.mỹĐứcDominoPizzaStopButton)
        val myKhanhTexasStartButton = findViewById<Button>(R.id.mỹKhánhTexasStartButton)
        val myKhanhTexasStopButton = findViewById<Button>(R.id.mỹKhánhTexasStopButton)
        val happyValleyBlock1StartButton = findViewById<Button>(R.id.happyValleyBlock1StartButton)
        val happyValleyBlock1StopButton = findViewById<Button>(R.id.happyValleyBlock1StopButton)

        val startBtn = findViewById<Button>(R.id.startBus)
        val stopBtn = findViewById<Button>(R.id.stopBus)

        val busData = hashMapOf(
            "startStop" to "5호차 운행중",

            "grandViewC" to "그랜드뷰 C",
            "grandViewA" to "그랜드뷰 A",
            "mỹPhúc" to "미푹",
            "lýLongTường" to "리롱텅",
            "mỹPhátSopanDonpan" to "미팟(소판돈판)",
            "mỹĐứcDomino’sPizza" to "미득(도미노 피자)",
            "mỹKhánhTexas" to "미칸(텍사스)",
            "happyValleyBlock1" to "해피밸리"
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
            busInfo.update("startStop", "5호차 운행 중지")
                .addOnSuccessListener {
                    Toast("성공")
                }
                .addOnCanceledListener {
                    Toast("실")
                }
            true
        }


        grandViewCStartButton.setOnClickListener {
            busInfo.update("grandViewC", "그랜드뷰 C 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        grandViewCStartButton.setOnLongClickListener {
            busInfo.update("grandViewC", "그랜드뷰 C 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "fail")
                }
            true
        }


        grandViewCStopButton.setOnClickListener {
            busInfo.update("grandViewC", "그랜드뷰 C 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        grandViewCStopButton.setOnLongClickListener {
            busInfo.update("grandViewC", "그랜드뷰 C 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        grandViewAStartButton.setOnClickListener {
            busInfo.update("grandViewA ", "그랜드뷰 A 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        grandViewAStartButton.setOnLongClickListener {
            busInfo.update("grandViewA", "그랜드뷰 A 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        grandViewAStopButton.setOnClickListener {
            busInfo.update("grandViewA", "그랜드뷰 A 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        grandViewAStopButton.setOnLongClickListener {
            busInfo.update("grandViewA", "그랜드뷰 A 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myPhucStartButton.setOnClickListener {
            busInfo.update("mỹPhúc", "미푹 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myPhucStartButton.setOnLongClickListener {
            busInfo.update("mỹPhúc", "미푹 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myPhucStopButton.setOnClickListener {
            busInfo.update("mỹPhúc", "미푹 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myPhucStopButton.setOnLongClickListener {
            busInfo.update("mỹPhúc", "미푹 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        lyLongTuongStartButton.setOnClickListener {
            busInfo.update("lýLongTường", "리롱텅 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        lyLongTuongStartButton.setOnLongClickListener {
            busInfo.update("lýLongTường", "리롱텅 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        lyLongTuongStopButton.setOnClickListener {
            busInfo.update("lýLongTường", "리롱텅 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        lyLongTuongStopButton.setOnLongClickListener {
            busInfo.update("lýLongTường", "리롱텅 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myPhatSopanDonpanStartButton.setOnClickListener {
            busInfo.update("mỹPhátSopanDonpan", "미팟(소판돈판) 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myPhatSopanDonpanStartButton.setOnLongClickListener {
            busInfo.update("mỹPhátSopanDonpan", "미팟(소판돈판) 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myPhatSopanDonpanStopButton.setOnClickListener {
            busInfo.update("mỹPhátSopanDonpan", "미팟(소판돈판) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myPhatSopanDonpanStopButton.setOnLongClickListener {
            busInfo.update("mỹPhátSopanDonpan", "미팟(소판돈판) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myDucDominoPizzaStartButton.setOnClickListener {
            busInfo.update("mỹĐứcDomino’sPizza", "미득(도미노 피자) 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myDucDominoPizzaStartButton.setOnLongClickListener {
            busInfo.update("mỹĐứcDomino’sPizza", "미득(도미노 피자) 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myDucDominoPizzaStopButton.setOnClickListener {
            busInfo.update("mỹĐứcDomino’sPizza", "미득(도미노 피자) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myDucDominoPizzaStopButton.setOnLongClickListener {
            busInfo.update("mỹĐứcDomino’sPizza", "미득(도미노 피자) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myKhanhTexasStartButton.setOnClickListener {
            busInfo.update("mỹKhánhTexas", "미칸(텍사스) 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myKhanhTexasStartButton.setOnLongClickListener {
            busInfo.update("mỹKhánhTexas", "미칸(텍사스) 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        myKhanhTexasStopButton.setOnClickListener {
            busInfo.update("mỹKhánhTexas", "미칸(텍사스) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        myKhanhTexasStopButton.setOnLongClickListener {
            busInfo.update("mỹKhánhTexas", "미칸(텍사스) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        happyValleyBlock1StartButton.setOnClickListener {
            busInfo.update("happyValleyBlock1", "해피밸리 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        happyValleyBlock1StartButton.setOnLongClickListener {
            busInfo.update("happyValleyBlock1", "해피밸리 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        happyValleyBlock1StopButton.setOnClickListener {
            busInfo.update("happyValleyBlock1", "해피밸리 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        happyValleyBlock1StopButton.setOnLongClickListener {
            busInfo.update("happyValleyBlock1", "해피밸리 지났습니다")
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