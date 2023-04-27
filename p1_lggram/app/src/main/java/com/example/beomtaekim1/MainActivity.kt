package com.example.beomtaekim1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.beomtaekim1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Activity_sub1::class.java)
        binding.button.setOnClickListener({startActivity(intent)})

        val intent_time = Intent(this@MainActivity,MyReceiver::class.java)

        sendBroadcast(intent_time)
        Log.d("first_lifecycle","first_create")


    }


    override fun onStart() {
        super.onStart()
        Log.d("first_lifecycle","first_start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("first_lifecycle","first_Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("first_lifecycle","first_Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("first_lifecycle","first_stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("first_lifecycle","first_destroy")
    }

}

