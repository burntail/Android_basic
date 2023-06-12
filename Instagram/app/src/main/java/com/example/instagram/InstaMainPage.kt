package com.example.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class InstaMainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_main_page)

        val tabs = findViewById<TabLayout>(R.id.main_tab)
        tabs.addTab(tabs.newTab().setIcon(R.drawable.home_btn))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.add_btn))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.account_btn))


        val main_pageer = findViewById<ViewPager2>(R.id.main_pager)
        main_pageer.adapter=InstaMainpageAdapter(this@InstaMainPage,3)
        tabs.addOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                main_pageer.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}

class InstaMainpageAdapter(fragmentActivity: FragmentActivity,val tabCount:Int):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->return InstaFeedFragment()
            1->return InstaPostFragment()
            else->return InstaProfileFragment() // position == 2
        }
    }
}