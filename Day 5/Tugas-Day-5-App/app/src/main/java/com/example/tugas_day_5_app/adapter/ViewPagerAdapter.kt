@file:Suppress("DEPRECATION")

package com.example.tugas_day_5_app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tugas_day_5_app.feature_detail.FollowerFragment
import com.example.tugas_day_5_app.feature_detail.FollowingFragment

class ViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = arrayListOf(FollowerFragment(), FollowingFragment())
    private val titleList = arrayListOf("Follower", "Following")

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
}
