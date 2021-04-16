package com.example.mp3player_n1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mp3player_n1.fragments.SettingsFragment
import com.example.mp3player_n1.models.Category

class ViewPagerAdapter(var list: List<Category>,fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return SettingsFragment.newInstance(list[position].name!!, list[position].position!!)
    }

}