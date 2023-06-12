package com.example.youtube

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Video
import android.widget.MediaController
import android.widget.VideoView

class YoutubeItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_item)

        val videoUrl=intent.getStringExtra("video_url")

        val mediaController=MediaController(this@YoutubeItemActivity)


        findViewById<VideoView>(R.id.youtube_video_view).apply {
            this.setVideoURI(Uri.parse(videoUrl))
            this.setMediaController(mediaController) // 이걸해야지 미디어 컨드롤러가 보이면서 컨트롤이 가능
//            this.requestFocus()
            this.start()
//            mediaController.setAnchorView(this)
            mediaController.show()


        }

    }
}


// Exo player
//-기능이 다양
//-사용이 쉽다
//-DRM