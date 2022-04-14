package com.example.schoolbusapp.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.schoolbusapp.R
import com.example.schoolbusapp.databinding.ActivityTeacherMainBinding
import com.example.schoolbusapp.databinding.FragmentStudentHomeBinding
import com.example.schoolbusapp.databinding.FragmentTeacherHomeBinding
import com.example.schoolbusapp.main.student.bus.*
import com.google.android.material.tabs.TabLayoutMediator

class StudentHomeFragment : Fragment() {

    companion object {
        fun newInstance() : StudentHomeFragment {
            return StudentHomeFragment()
        }
    }
    private var mBinding: FragmentStudentHomeBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentStudentHomeBinding.inflate(inflater, container, false)

        val bus1 = B1Fragment()
        val bus2 = B2Fragment()
        val bus3 = B3Fragment()
        val bus4 = B4Fragment()
        val bus5 = B5Fragment()
        val bus6 = B6Fragment()
        val bus7 = B7Fragment()

        val fragments = arrayListOf<Fragment>(bus1,bus2, bus3, bus4, bus5, bus6, bus7)

        val tabAdapter = object : FragmentStateAdapter(this) {

            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
        binding.studentViewPager2.adapter = tabAdapter

        TabLayoutMediator(binding.studentTabLayout, binding.studentViewPager2) {tab,position ->
            when (position) {
                0 -> tab.setText(R.string.bus1Text)
                1 -> tab.setText(R.string.bus2Text)
                2 -> tab.setText(R.string.bus3Text)
                3 -> tab.setText(R.string.bus4Text)
                4 -> tab.setText(R.string.bus5Text)
                5 -> tab.setText(R.string.bus6Text)
                else -> tab.setText(R.string.bus7Text)

            }
        }.attach()


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }


}