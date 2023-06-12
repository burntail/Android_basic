package com.example.instagram

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.example.instagram.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var username:String=""
        var password:String=""

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instalogin)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService=retrofit.create(RetrofitService::class.java)

        findViewById<TextView>(R.id.enroll).setOnClickListener {
            val intent=Intent(this,InstaJoin::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        findViewById<EditText>(R.id.ID_blank).doAfterTextChanged {
            username=it.toString()
            Log.d("insta_login","${username}")
        }
        findViewById<EditText>(R.id.Password_blank).doAfterTextChanged {
            password=it.toString()
            Log.d("insta_login","${password}")
        }

        findViewById<TextView>(R.id.login_button).setOnClickListener {
            val user=HashMap<String,Any>()
            user.put("username",username)
            user.put("password",password)

            Log.d("insta_login","${user}")
            retrofitService.instaLogin(user).enqueue(object: Callback<Token> {
                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    if(response.isSuccessful){
                        //네트워크 연결 확인용
//                        val log=response.body()?.token.toString()
//                        Log.d("insta_login","sucssess: ${log}")
                        val token:Token=response.body()!!

                        val userToken=response.body()!!
                        val sharedPreferences=getSharedPreferences("user_info", Context.MODE_PRIVATE)
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString("token",userToken.token)
                        editor.putString("token",userToken.id.toString())
                        editor.commit()

                        //InstaMainPage로 로그인 하기 (로그인상태)
                        startActivity(Intent(this@InstaLogin,InstaMainPage::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))


                    }
                }

                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Log.d("insta_login","Fail: ${t.message}")

                   Toast.makeText(this@InstaLogin,"Access Denied! Please check again!",Toast.LENGTH_LONG).show()

                }

            })
        }
    }
}