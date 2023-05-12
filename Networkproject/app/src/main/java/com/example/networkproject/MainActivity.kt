package com.example.networkproject

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        NetworkAsyncTask().execute()



    }


}

class NetworkAsyncTask():AsyncTask<Any?,Any?,Any?>(){
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString : String ="https://dummyjson.com/products/1"
        val url: URL = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection
        //요청함
        connection.requestMethod="GET"
        connection.setRequestProperty("Content-Type","application/json")

//        connection.connect()

//        //요청받음
        var buffer=""



        if(connection.responseCode == HttpURLConnection.HTTP_OK){
            val reader=BufferedReader(
                InputStreamReader(connection.inputStream,
                    "UTF-8"
                )
            )

            buffer=reader.readLine()
            Log.d("Network test",buffer)

        }

        return null
    }

}