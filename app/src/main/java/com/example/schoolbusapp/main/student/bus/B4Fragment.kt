package com.example.schoolbusapp.main.student.bus

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.FragmentB3Binding
import com.example.schoolbusapp.databinding.FragmentB4Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class B4Fragment : Fragment() {

    private var mBining : FragmentB4Binding? = null
    private val binding get() = mBining!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBining = FragmentB4Binding.inflate(inflater, container, false)

        val db = Firebase.firestore

        val docRef = db.collection("busInfo").document("b4")
        docRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                val startText1 = snapshot.data!!["skyGarden1and2CircleK"].toString()
                val startText2 = snapshot.data!!["riverParkBlockAWooriBank"].toString()
                val startText3 = snapshot.data!!["riverParkVBIBank"].toString()
                val startText4 = snapshot.data!!["gardenPlaza1BlockA"].toString()
                val startText5 = snapshot.data!!["gardenPlaza1BlockD"].toString()
                val startText6 = snapshot.data!!["panoramaBlockA"].toString()
                val startText7 = snapshot.data!!["panoramaBlockJ"].toString()
                val startText8 = snapshot.data!!["oakwoodResidenceGate"].toString()
                val startText9 = snapshot.data!!["meetworkMỹKhánh"].toString()

                val startStopText = snapshot.data!!["startStop"].toString()
                val busStartStop = binding.startStopBusTextView

                binding.skyGarden1and2CircleK.text = startText1
                binding.riverParkBlockA.text = startText2
                binding.MeetworkMKhNh3.text = startText9
                binding.riverAParkVBIBank.text = startText3
                binding.gardenPlaza1BlockA.text = startText4
                binding.gardenPlaza1BlockD.text = startText5
                binding.panoramaBlockA.text = startText6
                binding.panoramaBlockJ.text = startText7
                binding.oakwoodResidenceGate1.text = startText8

                busStartStop.text = startStopText


                Log.d(ContentValues.TAG, "성공")
            } else {
                Log.d(ContentValues.TAG, " data: null")
            }
        }

        return binding.root
    }


}