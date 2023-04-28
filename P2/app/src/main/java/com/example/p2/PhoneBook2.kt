package com.example.p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBook2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book2)

        val container_2=findViewById<LinearLayout>(R.id.container_2)
        val inflater = LayoutInflater.from(this@PhoneBook2)

        var phonebooklist = ArrayList<PhoneBook>()
        for (i in 0..30){
            phonebooklist.add(PhoneBook(""+i+"번째 사람","010-0000-00"+i))
        }





        phonebooklist.forEach{ phoneBook ->
            val phonebookItem=inflater.inflate(R.layout.phone_book_item,null)
            val image = phonebookItem.findViewById<ImageView>(R.id.image_1)
            val name = phonebookItem.findViewById<TextView>(R.id.name)
            val number =  phonebookItem.findViewById<TextView>(R.id.number)

            image.setImageDrawable(resources.getDrawable(R.drawable.ic_launcher_foreground,this.theme))
            name.text = phoneBook.name
            number.text = phoneBook.number

            container_2.addView(phonebookItem)
        }


    }

}

class PhoneBook(val name:String, val number:String)

