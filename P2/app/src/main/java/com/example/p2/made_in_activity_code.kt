package com.example.p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class made_in_activity_code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_made_in_code)

        val image=ImageView(this).also{
            it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.spirit))
        }



        val layout=LinearLayout(this).apply {
            orientation=LinearLayout.VERTICAL
            gravity=Gravity.CENTER
            addView(image,WRAP_CONTENT,WRAP_CONTENT)

        }

        setContentView(layout)


    }
}