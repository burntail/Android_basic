package com.example.p2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FragmentAndAddviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_and_addview)

        val fragmentmanager =supportFragmentManager
        val fragmentfirst=FragmentFirst()
        //Transaction
        // - 작업의 단위 -

        //
//        commit 종류
//                1) commit : 저장을 한 경우 실행을 할 수 없다 (IllegalStateException)
//                2) commitAllowingStateLoss : 저장을 한 경우 예외가 발생하지 않고 그냥 손실
//                3) commitNow
//                4) commitNowAllowingStateLoss
//        commit - commitAllowingStateLoss(AllowingStateLoss)
//        -상태손실을 허락한다
//        -onStop, lifecycle 또는 os에 의해서 앱이 상태를 저장해야 할 수 있다
//                -상태손실->
//            commit - commitNow(Now)

        (findViewById<TextView>(R.id.attach)).setOnClickListener {

            val transaction = fragmentmanager.beginTransaction() // work start
            // 프래그머트에 데이터를 전달하는 방법
            val bundle = Bundle()
            bundle.putString("key","hello")
            fragmentfirst.arguments =bundle

            transaction.replace(R.id.root,fragmentfirst)
            transaction.commit() // 끝

        }

        (findViewById<TextView>(R.id.dettach)).setOnClickListener {
            val transaction = fragmentmanager.beginTransaction() // work start
            transaction.remove(fragmentfirst)
            transaction.commit() // 끝
        }

    }

    override fun onStart() {
        super.onStart()

        Log.d("Fragment_Lifecycle","Fragment activity onStart")
    }

    override fun onResume() {
        super.onResume()


        Log.d("Fragment_Lifecycle","Fragment activity onResume")


    }

    override fun onPause() {
        super.onPause()


        Log.d("Fragment_Lifecycle","Fragment activity onPause")
    }

    override fun onStop() {
        super.onStop()


        Log.d("Fragment_Lifecycle","Fragment activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()


        Log.d("Fragment_Lifecycle","Fragment activity onDestroy")
    }
}