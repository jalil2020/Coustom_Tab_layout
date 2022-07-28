package com.example.coustomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(
    private val pathList: List<String>,
    fm: FragmentManager,
    lc: Lifecycle
) :
    FragmentStateAdapter(fm, lc) {
    override fun getItemCount(): Int = pathList.size

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            else -> FragmentOne()
        }
    }
}