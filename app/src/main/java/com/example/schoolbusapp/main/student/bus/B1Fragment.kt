package com.example.schoolbusapp.main.student.bus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.FragmentB1Binding
import com.example.schoolbusapp.databinding.FragmentTeacherHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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

        val b1Text = binding.Test


        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.child("start")
                b1Text.text = "$value"
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("error", "실패")
            }
        })

        return binding.root
    }


}