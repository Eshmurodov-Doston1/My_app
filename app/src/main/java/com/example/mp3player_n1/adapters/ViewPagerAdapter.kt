package com.example.mp3player_n1.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mp3player_n1.fragments.Homeragment
import com.example.mp3player_n1.fragments.SettingsFragment
import com.example.mp3player_n1.fragments.UserFragment
import com.example.mp3player_n1.models.Category

class ViewPagerAdapter(var list: List<Category>,fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager,
BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return   Homeragment.newInstance(list[position].name!!, list[position].position!!)
            }
            1->{
                return   SettingsFragment.newInstance(list[position].name!!, list[position].position!!)
            }
            2->{
                return UserFragment.newInstance(list[position].name!!, list[position].position!!)
            }
            else ->{
                return Homeragment()
            }
        }
    }

}