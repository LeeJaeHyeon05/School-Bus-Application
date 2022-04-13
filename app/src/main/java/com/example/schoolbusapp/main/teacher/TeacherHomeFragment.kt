package com.example.schoolbusapp.main.teacher

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.schoolbusapp.*
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

        busNumButton()


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
            startActivity(Intent(requireContext(), B1Activity::class.java))
        }
        b2.setOnClickListener {
            startActivity(Intent(requireContext(), B2Activity::class.java))
        }
        b3.setOnClickListener {
            startActivity(Intent(requireContext(), B3Activity::class.java))
        }
        b4.setOnClickListener {
            startActivity(Intent(requireContext(), B4Activity::class.java))
        }
        b5.setOnClickListener {
            startActivity(Intent(requireContext(), B5Activity::class.java))
        }
        b6.setOnClickListener {
            startActivity(Intent(requireContext(), B6Activity::class.java))
        }
        b7.setOnClickListener {
            startActivity(Intent(requireContext(), B7Activity::class.java))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}