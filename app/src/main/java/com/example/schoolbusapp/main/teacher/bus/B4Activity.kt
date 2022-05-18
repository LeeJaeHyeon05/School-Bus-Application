package com.example.schoolbusapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class B4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b4)
        val db = Firebase.firestore

        val busInfo = db.collection("busInfo").document("b4")

        val skyGarden1and2CircleKStartButton = findViewById<Button>(R.id.skyGarden1and2CircleKStartButton)
        val skyGarden1and2CircleKStopButton = findViewById<Button>(R.id.skyGarden1and2CircleKStopButton)
        val riverParkBlockAStartButton = findViewById<Button>(R.id.riverParkBlockAStartButton)
        val riverParkBlockAStopButton = findViewById<Button>(R.id.riverParkBlockAStopButton)
        val meetWorkMyKhanhStartButton = findViewById<Button>(R.id.MeetworkMỹKhánh3StartButton)
        val meetWorkMyKhanhStopButton = findViewById<Button>(R.id.MeetworkMỹKhánh3StopButton)
        val riverParkVBIBankStartButton = findViewById<Button>(R.id.riverParkVBIBankStartButton)
        val riverParkVBIBankStopButton = findViewById<Button>(R.id.riverParkVBIBankStopButton)
        val gardenPlazaBlockAStartButton = findViewById<Button>(R.id.gardenPlazaBlockAStartButton)
        val gardenPlazaBlockAStopButton = findViewById<Button>(R.id.gardenPlazaBlockAStopButton)
        val gardenPlazaBlockDStartButton = findViewById<Button>(R.id.gardenPlazaBlockDStartButton)
        val gardenPlazaBlockDStopButton = findViewById<Button>(R.id.gardenPlazaBlockDStopButton)
        val panoramaBlockAStartButton = findViewById<Button>(R.id.panoramaBlockAStartButton)
        val panoramaAStopButton = findViewById<Button>(R.id.panoramaAStopButton)
        val panoramaBlockJStartButton = findViewById<Button>(R.id.panoramaBlockJStartButton)
        val panoramaJStopButton = findViewById<Button>(R.id.panoramaJStopButton)
        val oakwoodResidenceGate1StartButton = findViewById<Button>(R.id.oakwoodResidenceGate1StartButton)
        val oakwoodResidenceGate1StopButton = findViewById<Button>(R.id.oakwoodResidenceGate1StopButton)


        val startBtn = findViewById<Button>(R.id.startBus)
        val stopBtn = findViewById<Button>(R.id.stopBus)

        val busData = hashMapOf(
            "startStop" to "4호차 운행중",
            "skyGarden1and2CircleK" to "스카이가든 1,2 서클케이",
            "riverParkBlockAWooriBank" to "리버파크 우리 뱅크",
            "riverParkVBIBank" to "리버파크 VBI은행",
            "meetworkMỹKhánh" to "미칸",
            "gardenPlaza1BlockA" to "가든플라자 A",
            "gardenPlaza1BlockD" to "가든플라자 D",
            "panoramaBlockA" to "파노라마 A",
            "panoramaBlockJ" to "파노라마 J",
            "oakwoodResidenceGate" to "왁우드레지덴스"
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
            busInfo.update("startStop", "4호차 운행 중지")
                .addOnSuccessListener {
                    Toast("성공")
                }
                .addOnCanceledListener {
                    Toast("실")
                }
            true
        }


        skyGarden1and2CircleKStartButton.setOnClickListener {
            busInfo.update("skyGarden1and2CircleK", "스카이가든 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        skyGarden1and2CircleKStartButton.setOnLongClickListener {
            busInfo.update("skyGarden1and2CircleK", "스카이가든 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_LONG).show()
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "fail")
                }
            true
        }


        skyGarden1and2CircleKStopButton.setOnClickListener {
            busInfo.update("skyGarden1and2CircleK", "스카이가든 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        skyGarden1and2CircleKStopButton.setOnLongClickListener {
            busInfo.update("skyGarden1and2CircleK", "스카이가든 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        riverParkBlockAStartButton.setOnClickListener {
                busInfo.update("riverParkBlockAWooriBank ", "리버파크(우리은행) 가고 있습니다")
                    .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        riverParkBlockAStartButton.setOnLongClickListener {
            busInfo.update("riverParkBlockAWooriBank", "리버파크(우리은행) 도착 5분전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        riverParkBlockAStopButton.setOnClickListener {
            busInfo.update("riverParkBlockAWooriBank", "리버파크(우리은행) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        riverParkBlockAStopButton.setOnLongClickListener {
            busInfo.update("riverParkBlockAWooriBank", "리버파크(우리은행) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        meetWorkMyKhanhStartButton.setOnClickListener {
            busInfo.update("meetworkMỹKhánh", "미칸 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        meetWorkMyKhanhStartButton.setOnLongClickListener {
            busInfo.update("meetworkMỹKhánh", "미칸 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        meetWorkMyKhanhStopButton.setOnClickListener {
            busInfo.update("meetworkMỹKhánh", "미칸 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        meetWorkMyKhanhStopButton.setOnLongClickListener {
            busInfo.update("meetworkMỹKhánh", "미칸 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }

        riverParkVBIBankStartButton.setOnClickListener {
            busInfo.update("riverParkVBIBank", "리버파크(VBI은행) 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        riverParkVBIBankStartButton.setOnLongClickListener {
            busInfo.update("riverParkVBIBank", "리버파크(VBI은행) 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        riverParkVBIBankStopButton.setOnClickListener {
            busInfo.update("riverParkVBIBank", "리버파크(VBI은행) 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        riverParkVBIBankStopButton.setOnLongClickListener {
            busInfo.update("riverParkVBIBank", "리버파크(VBI은행) 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        gardenPlazaBlockAStartButton.setOnClickListener {
            busInfo.update("gardenPlaza1BlockA", "가든플라자 A 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        gardenPlazaBlockAStartButton.setOnLongClickListener {
            busInfo.update("gardenPlaza1BlockA", "가든플라자 A 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        gardenPlazaBlockAStopButton.setOnClickListener {
            busInfo.update("gardenPlaza1BlockA", "가든플라자 A에 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        gardenPlazaBlockAStopButton.setOnLongClickListener {
            busInfo.update("gardenPlaza1BlockA", "가든플라자 A 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        gardenPlazaBlockDStartButton.setOnClickListener {
            busInfo.update("gardenPlaza1BlockD", "가든플라자 D 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        gardenPlazaBlockDStartButton.setOnLongClickListener {
            busInfo.update("gardenPlaza1BlockD", "가든플라자 D 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        gardenPlazaBlockDStopButton.setOnClickListener {
            busInfo.update("gardenPlaza1BlockD", "가든플라자 D 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        gardenPlazaBlockDStopButton.setOnLongClickListener {
            busInfo.update("gardenPlaza1BlockD", "가든플라자 D 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        panoramaBlockAStartButton.setOnClickListener {
            busInfo.update("panoramaBlockA", "파노라마 A 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        panoramaBlockAStartButton.setOnLongClickListener {
            busInfo.update("panoramaBlockA", "파노라마 A 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        panoramaAStopButton.setOnClickListener {
            busInfo.update("panoramaBlockA", "파노라마 A 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        panoramaAStopButton.setOnLongClickListener {
            busInfo.update("panoramaBlockA", "파노라마 A 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        panoramaBlockJStartButton.setOnClickListener {
            busInfo.update("panoramaBlockJ", "파노라마 J 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        panoramaBlockJStartButton.setOnLongClickListener {
            busInfo.update("panoramaBlockJ", "파노라마 J 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        panoramaJStopButton.setOnClickListener {
            busInfo.update("panoramaBlockJ", "파노라마 J 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        panoramaJStopButton.setOnLongClickListener {
            busInfo.update("panoramaBlockJ", "파노라마 J 지났습니다")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        oakwoodResidenceGate1StartButton.setOnClickListener {
            busInfo.update("oakwoodResidenceGate", "왁우드레지덴스 가고 있습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        oakwoodResidenceGate1StartButton.setOnLongClickListener {
            busInfo.update("oakwoodResidenceGate", "왁우드레지덴스 도착 5분 전")
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 성공", android.widget.Toast.LENGTH_SHORT).show()

                }
                .addOnSuccessListener {
                    android.widget.Toast.makeText(this, "버튼 실패 다시 해주세요", android.widget.Toast.LENGTH_SHORT).show()
                }
            true
        }
        oakwoodResidenceGate1StopButton.setOnClickListener {
            busInfo.update("oakwoodResidenceGate", "왁우드레지덴스 도착 했습니다")
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "성공")
                }
                .addOnCanceledListener {
                    Log.d(ContentValues.TAG, "실패")
                }
        }
        oakwoodResidenceGate1StopButton.setOnLongClickListener {
            busInfo.update("oakwoodResidenceGate", "왁우드레지덴스 지났습니다")
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