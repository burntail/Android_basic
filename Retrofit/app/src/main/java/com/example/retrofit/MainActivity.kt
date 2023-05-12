package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //서버 -> 읽을 수 없는 데이터 -> JSON -> Gson
        //Gson -> 읽을 수 없는 데이터를 코틀린 객체로 바꿔줌
        val retrofit=Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(GsonConverterFactory.create()).build()//시리얼라이즈해서 json으로 convert 함
        val retrofitService=retrofit.create(retrofitservie::class.java)

        retrofitService.getproductlist().enqueue(object : Callback<mosigai>{
            override fun onResponse(call: Call<mosigai>, response: Response<mosigai>) {
                val list=response.body()
//                Log.d("testt",""+list!!.products)
                list!!.products.forEach {
                    Log.d("testt",""+it)
                }
             }

            override fun onFailure(call: Call<mosigai>, t: Throwable) {
                Log.d("testt", t.stackTraceToString())
            }
        })

    }
}


