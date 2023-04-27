package com.example.beomtaekim1

import android.R
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import androidx.annotation.Nullable


class Musicservice : Service() {

    private var mediaPlayer: MediaPlayer? = null

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        Log.i("서비스 테스트", "onCreate()")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.i("서비스 테스트", "onDestroy()")
        mediaPlayer!!.stop() //음악 중지
        super.onDestroy()
    }

//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Log.i("서비스 테스트", "onStartCommand()")
//        mediaPlayer = MediaPlayer.create(this, R.raw.test) //mp3시작 및 반복
//        mediaPlayer!!.isLooping = true
//        mediaPlayer!!.start()
//        return super.onStartCommand(intent, flags, startId)
//    }

}