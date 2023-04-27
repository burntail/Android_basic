package com.example.beomtaekim1


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context,"Time Check",Toast.LENGTH_SHORT).show()

        when(intent?.action)
        {

            Intent.ACTION_SCREEN_ON -> Log.d("screen_beomtae","screen on")
            Intent.ACTION_SCREEN_OFF -> Log.d("screen_beomtae","screen off")
        }

    }
}