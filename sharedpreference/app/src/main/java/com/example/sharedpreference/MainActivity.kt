package com.example.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.create).setOnClickListener {
            val sharedpreference:SharedPreferences=getSharedPreferences("table_name", Context.MODE_PRIVATE)
            //MODE_PRIVATE -> 현재 앱에서만 사용을 하겠다 -> 다른 앱과 공유하지 않음
            //MODE_WORLD_READBLE ->  다른 앱에서도 사용가능(읽기만)
            //MODE_WORLD_WRITABLE: 다른 앱에서도 사용가능 ( 읽기, 쓰기 가능)
            //MODE_MULTI_PROCESS: 이미 호출되어 사용중인지 체크
            // MODE_APPEND : 기존 preference에 신규로 추가
            val editor :  SharedPreferences.Editor = sharedpreference.edit()
            editor.putString("key1","hello one") // key-value 방식으로 저장
            editor.putString("key2","hello two")
            editor.commit()


        }
        findViewById<TextView>(R.id.read).setOnClickListener {
            val sharedpreference:SharedPreferences=getSharedPreferences("table_name", Context.MODE_PRIVATE)

            val valueOne = sharedpreference.getString("key1","hello")
            val valueTwo = sharedpreference.getString("key2","hello")
            Log.d("preference read",valueOne!!)
            Log.d("preference read",valueTwo!!)

        }
        findViewById<TextView>(R.id.update).setOnClickListener {
            val sharedpreference:SharedPreferences=getSharedPreferences("table_name", Context.MODE_PRIVATE)

            val editor :  SharedPreferences.Editor = sharedpreference.edit()
            editor.putString("key1","hello hello") // key-value 방식으로 저장
//            editor.putString("key2","hello")
            editor.commit()

        }
        findViewById<TextView>(R.id.delete).setOnClickListener {
            val sharedpreference:SharedPreferences=getSharedPreferences("table_name", Context.MODE_PRIVATE)


            val editor :  SharedPreferences.Editor = sharedpreference.edit()
            editor.clear()
            editor.commit()

        }
    }
}