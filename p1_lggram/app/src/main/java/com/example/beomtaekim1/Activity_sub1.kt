package com.example.beomtaekim1

import android.R
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.beomtaekim1.databinding.ActivitySub1Binding


class Activity_sub1 : AppCompatActivity() {

    val binding by lazy { ActivitySub1Binding.inflate(layoutInflater)}
    private val intent_music = Intent(this,Musicservice::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)
        binding.button.setOnClickListener({startActivity(intent)})

        setBroadcastReceiver()

        binding.startBtn.setOnClickListener {
            startService(intent)
            Log.i("Music Start Service", "StartService()")
        }

        binding.stopBtn.setOnClickListener {
            stopService(intent)
            Log.i("Music Stop Service", "StopService()")
        }

        Log.d("second_lifecycle","second_create")


    }

    override fun onStart() {
        super.onStart()
        Log.d("second_lifecycle","second_start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("second_lifecycle","second_Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("second_lifecycle","second_Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("second_lifecycle","second_stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("second_lifecycle","second_destroy")
    }

    private fun setBroadcastReceiver(){
        val receiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                when(intent?.action)
                {
                    Intent.ACTION_SCREEN_ON -> Log.d("screen_beomtae","screen on")
                    Intent.ACTION_SCREEN_OFF -> Log.d("screen_beomtae","screen off")
                }
            }
        }

        val filter=IntentFilter(Intent.ACTION_SCREEN_ON).apply {
            addAction(Intent.ACTION_SCREEN_OFF)
        }

        registerReceiver(receiver,filter)
    }


}