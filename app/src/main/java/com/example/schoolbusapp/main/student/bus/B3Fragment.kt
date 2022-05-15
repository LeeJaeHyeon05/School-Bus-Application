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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.FirebaseDatabase


class B3Fragment : Fragment() {

    private var mBining : FragmentB3Binding? = null
    private val binding get() = mBining!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBining = FragmentB3Binding.inflate(inflater, container, false)

        val db = Firebase.firestore

        val docRef = db.collection("busInfo").document("b3")
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val startText1 = snapshot.data!!["masteriThaoDien"].toString()
                val startText2 = snapshot.data!!["theNassimGate"].toString()
                val startText3 = snapshot.data!!["estella"].toString()
                val startText4 = snapshot.data!!["imperia"].toString()
                val startText5 = snapshot.data!!["lexington"].toString()

                val startStopText = snapshot.data!!["startStop"].toString()
                val busStartStop = binding.startStopBusTextView

                binding.masteriThaoDienA4.text = startText1
                binding.theNassimGate.text = startText2
                binding.estella.text = startText3
                binding.imperia.text = startText4
                binding.lexington.text = startText5

                busStartStop.text = startStopText


                Log.d(ContentValues.TAG, "성공")
            } else {
                Log.d(ContentValues.TAG, " data: null")
            }
        }


        return binding.root
    }


}