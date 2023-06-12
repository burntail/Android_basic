package com.example.melon

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

class MelondetailActivity : AppCompatActivity() {
    lateinit var mediaPlayer:MediaPlayer
    lateinit var playPauseButton: ImageView
    lateinit var melonItemList:ArrayList<MelonItem>
    var currentPosition:Int=0

    var is_playing:Boolean=false
        set(value) {
            if (value==true){
                findViewById<ImageView>(R.id.play_icon).setImageDrawable(this.resources.getDrawable(R.drawable.stop,this.theme))

            }
            else{
                findViewById<ImageView>(R.id.play_icon).setImageDrawable(this.resources.getDrawable(R.drawable.start,this.theme))
            }
            field=value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melondetail)

        is_playing = true
//
        var melonItemList = intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>
        currentPosition=intent.getIntExtra("position",0)

        mediaPlayer=MediaPlayer.create(
            this,
            Uri.parse(melonItemList.get(currentPosition).song)
        )

        playPauseButton=findViewById(R.id.play_icon)

        //음악 앨범 표지 그리기
        var thumbnail=findViewById<ImageView>(R.id.thumbnail)
        val glide=Glide.with(this)
        glide.load(melonItemList.get(currentPosition).thumbnail).into(thumbnail)


        playmelonitem(melonItemList.get(currentPosition))

        playPauseButton.setOnClickListener {
            if (is_playing==true)
            {
                is_playing=false
                mediaPlayer.stop()
            }
            else
            {
                is_playing=true
                playmelonitem(melonItemList.get(currentPosition))
            }
        }

        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            mediaPlayer.stop()


            if (currentPosition==0){
                currentPosition=melonItemList.size-1
            }
            else{
                currentPosition--
            }

            playmelonitem(melonItemList.get(currentPosition))




        }

        findViewById<ImageView>(R.id.next_button).setOnClickListener {
            mediaPlayer.stop()

            if (currentPosition==melonItemList.size-1){
                currentPosition=0
            }
            else{
                currentPosition++
            }

            playmelonitem(melonItemList.get(currentPosition))
        }




    }

    fun playmelonitem(melonitem: MelonItem){

        mediaPlayer=MediaPlayer.create(
            this,
            Uri.parse(melonitem.song)
        )

        mediaPlayer.start()

    }
}