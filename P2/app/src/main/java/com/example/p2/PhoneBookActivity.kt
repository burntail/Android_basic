package com.example.p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        var phonebooklist = mutableListOf<PhoneBook>()
        for (i in 0..30){
            phonebooklist.add(PhoneBook(""+i+"번째 사람","010-0000-00"+i))
        }

        val container=findViewById<LinearLayout>(R.id.container)
        val inflater = LayoutInflater.from(this)

        phonebooklist.forEach{
            phoneBook ->
            val phonebookItem=inflater.inflate(R.layout.activity_phone_book_detail,null)
            val image =phonebookItem.findViewById<ImageView>(R.id.image)
            val name = phonebookItem.findViewById<TextView>(R.id.name)
            val number =  phonebookItem.findViewById<TextView>(R.id.number)

            image.setImageDrawable(resources.getDrawable(R.drawable.calculation_button))
            name.text = phoneBook.name
            number.text = phoneBook.number

            container.addView(phonebookItem)
        }
    }
}


class PhoneBook(val name:String, val number:String)