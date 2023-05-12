package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// 참조 사이트 : https://minchanyoun.tistory.com/126
        var viewPager2Adatper_1 = ViewPager2Adapter(this@MainActivity)
        viewPager2Adatper_1.addFragment(Tab1Fragment())
        viewPager2Adatper_1.addFragment(Tab2Fragment())
        viewPager2Adatper_1.addFragment(Tab3Fragment())

        var pager_1=findViewById<ViewPager2>(R.id.vp_viewpager_main)
        var tab_1=findViewById<TabLayout>(R.id.tl_navigation_view)

        pager_1.adapter=viewPager2Adatper_1

        //registerOnPageChangeCallback은 ViewPager2.OnPageChangeCallback() 이라는 객체를 등록하는데 이 객체에 대한 동작을 처리 => onPageScrollStateChanged 라는 동작으로 구현
        //onPageScrollStateChanged(state: Int): 페이지 전환 상태가 변경되었을 때 호출되는 메서드 입니다 -> 전환 상태
        pager_1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
        // TabLayoutMediator는 TabLayout과 ViewPager2를 연결하여 탭과 페이지 사이의 상호작용을 관리하는 유틸리티 클래스입니다. 이 클래스를 사용하면 간단하게 탭과 페이지 간의 동기화를 설정
        TabLayoutMediator(tab_1,pager_1){tab,position->
            Log.d("tab section","tab change")

            when(position){
                0->tab.text="Tab1"
                1->tab.text="Tab2"
                2->tab.text="Tab3"
            }


        }.attach()







    }
}

class ViewPager2Adapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    var fragments: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
        //TODO: notifyItemInserted!!
    }

    fun removeFragement() {
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
        //TODO: notifyItemRemoved!!
    }

}



