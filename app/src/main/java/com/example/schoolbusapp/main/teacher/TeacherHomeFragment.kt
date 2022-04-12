package com.example.schoolbusapp.main.teacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.ActivityTeacherMainBinding
import com.example.schoolbusapp.databinding.FragmentTeacherHomeBinding
import com.example.schoolbusapp.main.StudentChatFragment

class TeacherHomeFragment : Fragment() {

    companion object {
        fun newInstance() : TeacherHomeFragment {
            return TeacherHomeFragment()
        }
    }
    private var mBinding: FragmentTeacherHomeBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTeacherHomeBinding.inflate(inflater, container, false)




        return binding.root
    }

    private fun busNumButton() {
        val b1 = binding.bus1Button
        val b2 = binding.bus2Button
        val b3 = binding.bus3Button
        val b4 = binding.bus4Button
        val b5 = binding.bus5Button
        val b6 = binding.bus6Button
        val b7 = binding.bus7Button

        b1.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}