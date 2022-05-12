package com.example.schoolbusapp.main.student.bus

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.FragmentB1Binding
import com.example.schoolbusapp.databinding.FragmentTeacherHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class B1Fragment : Fragment() {

    private var mBinding: FragmentB1Binding? = null
    private val binding get() = mBinding!!

    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("bus")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentB1Binding.inflate(inflater, container, false)

        val db = Firebase.firestore

        val docRef = db.collection("busInfo").document("b1")
        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val startText = snapshot.data!!["cantavil"].toString()
                binding.Cantavil.text = startText

                Log.d(TAG, "성공")
            } else {
                Log.d(TAG, " data: null")
            }
        }


        return binding.root
    }


}

//        db.collection("busInfo")
//            .whereEqualTo("cantavil",  true)
//            .get()
//            .addOnSuccessListener {
//                val cText = binding.Cantavil
//                cText.text = "도착 : (7:00) Cantavil 4HS"
//                cText.setTextColor(Color.BLACK)
//                binding.startStopBusTextView.setTextColor(Color.GREEN)
//            }
//            .addOnFailureListener {
//                Toast.makeText(requireContext(), "불러오기 실패", Toast.LENGTH_SHORT).show()
//                binding.startStopBusTextView.setTextColor(Color.RED)
//            }
//
//
//        db.collection("busInfo")
//            .whereEqualTo("cantavil",  false)
//            .get()
//            .addOnSuccessListener {
//                val cText = binding.Cantavil
//                cText.text = "운행안함 : (7:00) Cantavil 4HS"
//                cText.setTextColor(Color.GRAY)
//                binding.startStopBusTextView.setTextColor(Color.RED)
//            }
//            .addOnFailureListener {
//                Toast.makeText(requireContext(), "불러오기 실패", Toast.LENGTH_SHORT).show()
//                binding.startStopBusTextView.setTextColor(Color.RED)
//            }