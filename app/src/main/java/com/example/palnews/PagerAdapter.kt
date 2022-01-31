package com.example.palnews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm,behavior) {

    private var tabCount: Int = behavior

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {

        return when(position){

            0 -> HomeFragment()
            1 -> BusinessFragment()
            2 -> EntertainmentFragment()
            3 -> HealthFragment()
            4 -> ScienceFragment()
            5 -> SportsFragment()
            6 -> TechnologyFragment()
            else -> {
                HomeFragment()
            }
        }

    }


}