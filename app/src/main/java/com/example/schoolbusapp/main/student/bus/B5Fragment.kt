package com.example.schoolbusapp.main.student.bus

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.FragmentB4Binding
import com.example.schoolbusapp.databinding.FragmentB5Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class B5Fragment : Fragment() {


    private var mBinding : FragmentB5Binding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentB5Binding.inflate(inflater, container, false)

        val db = Firebase.firestore

        val docRef = db.collection("busInfo").document("b5")
        docRef.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {
                val startText1 = snapshot.data!!["grandViewC"].toString()
                val startText2 = snapshot.data!!["grandViewA"].toString()
                val startText3 = snapshot.data!!["mỹPhúc"].toString()
                val startText4 = snapshot.data!!["lýLongTường"].toString()
                val startText5 = snapshot.data!!["mỹPhátSopanDonpan"].toString()
                val startText6 = snapshot.data!!["mỹĐứcDomino’sPizza"].toString()
                val startText7 = snapshot.data!!["mỹKhánhTexas"].toString()
                val startText8 = snapshot.data!!["happyValleyBlock1"].toString()

                val startStopText = snapshot.data!!["startStop"].toString()
                val busStartStop = binding.startStopBusTextView

                binding.grandViewC.text = startText1
                binding.grandViewA.text = startText2
                binding.myPhuc.text = startText3
                binding.lLongTNg.text = startText4
                binding.myPhatSopanDonpan.text = startText5
                binding.myDucDominosPizza.text = startText6
                binding.myKhanhTexas.text = startText7
                binding.happyValleyBlock1.text = startText8

                busStartStop.text = startStopText


                Log.d(ContentValues.TAG, "성공")
            } else {
                Log.d(ContentValues.TAG, " data: null")
            }
        }

        return binding.root
    }


}