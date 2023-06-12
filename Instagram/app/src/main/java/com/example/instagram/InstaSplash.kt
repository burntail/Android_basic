package com.example.instagram

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class InstaSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_splash)

        val sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE)
        val token=sharedPreferences.getString("token","empty")



        when(token){
            "empty"->{
                //로그인이 되어 있지 않는 경우(sharedPreference에 이미 유저내용이 저장되어 있지 않음)
                startActivity(Intent(this@InstaSplash,InstaLogin::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
            }
            else->{
                //로그인이 되어 있는 경우(sharedPreference에 이미 유저내용이 저장)
                startActivity(Intent(this@InstaSplash,InstaMainPage::class.java))

            }
        }

    }


}