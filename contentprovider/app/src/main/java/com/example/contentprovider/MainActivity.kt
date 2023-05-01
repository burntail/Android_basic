package com.example.contentprovider

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
//import android.media.MediaStore
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.*
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var uri: Uri? = null
    private lateinit var imageView: ImageView

    private val startActivityResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            uri = result.data?.data
            try {
                val bitmap: Bitmap? = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                imageView.setImageBitmap(bitmap)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selectImageBtn: Button = findViewById(R.id.take_picture)
        imageView = findViewById(R.id.image_1)

        selectImageBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityResult.launch(intent)
        })
    }




}