package com.example.tabtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tab=findViewById<TabLayout>(R.id.tablayout)
        var pager=findViewById<ViewPager>(R.id.viewpager)

        //tab을 추가해주는 기능
        tab.addTab(tab.newTab().setText("first"))
        tab.addTab(tab.newTab().setText("second"))

        //pager에 view를 contact
        pager.adapter=FragmentPagerAdapter(supportFragmentManager,2)

        tab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })




    }
}

class FragmentPagerAdapter(var fragmentmanager:FragmentManager,var tabCount:Int): FragmentStatePagerAdapter(fragmentmanager){


    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0->return  FragmentFirst()
            else ->return  FragmentSecond()

        }
    }


}