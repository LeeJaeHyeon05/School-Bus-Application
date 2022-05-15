package com.example.schoolbusapp.main.student.bus

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.FragmentB5Binding
import com.example.schoolbusapp.databinding.FragmentB6Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class B6Fragment : Fragment() {


    private var mBinding : FragmentB6Binding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentB6Binding.inflate(inflater, container, false)

        val db = Firebase.firestore

        val docRef = db.collection("busInfo").document("b6")
        docRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                val startText1 = snapshot.data!!["skyGarden3CircleK"].toString()
                val startText2 = snapshot.data!!["scenicValley2ParisBaguette"].toString()
                val startText3 = snapshot.data!!["scenicValley1"].toString()
                val startText4 = snapshot.data!!["greenValley"].toString()

                val startStopText = snapshot.data!!["startStop"].toString()
                val busStartStop = binding.startStopBusTextView

                binding.skyGarden3CircleK.text = startText1
                binding.scenicValley2ParisBaguette.text = startText2
                binding.scenicValley1Gate1.text = startText3
                binding.greenValley.text = startText4

                busStartStop.text = startStopText


                Log.d(ContentValues.TAG, "성공")
            } else {
                Log.d(ContentValues.TAG, " data: null")
            }
        }

        return binding.root
    }


}