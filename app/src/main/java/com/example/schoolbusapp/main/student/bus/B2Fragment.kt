package com.example.schoolbusapp.main.student.bus

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.FragmentB2Binding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class B2Fragment : Fragment() {

    private var mBinding : FragmentB2Binding? = null
    private val binding get() = mBinding!!

    private val database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentB2Binding.inflate(inflater, container, false)

        val db = Firebase.firestore

        val docRef = db.collection("busInfo").document("b2")
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val startText1 = snapshot.data!!["sapphiraSaigonPearlTower"].toString()
                val startText2 = snapshot.data!!["newCity,ThuThiem1"].toString()
                val startText3 = snapshot.data!!["newCity,ThuThiem2"].toString()
                val startText4 = snapshot.data!!["theSunAvenueSAV"].toString()

                val startStopText = snapshot.data!!["startStop"].toString()
                val busStartStop = binding.startStopBusTextView

                binding.sapphiraSaigonPearlTower.text = startText1
                binding.newcity1.text = startText2
                binding.newcity2.text = startText3
                binding.theSunAvenueSAVSubgate.text = startText4

                busStartStop.text = startStopText


                Log.d(ContentValues.TAG, "성공")
            } else {
                Log.d(ContentValues.TAG, " data: null")
            }
        }



        return binding.root
    }

}