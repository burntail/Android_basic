package com.example.p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.marginBottom
import org.w3c.dom.Text

class PhoneBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

//        val container=findViewById<LinearLayout>(R.id.container_1)
//        val inflater = LayoutInflater.from(this@PhoneBookActivity)
//
//        var phonebooklist = mutableListOf<PhoneBook>()
////        for (i in 0..3){
////            phonebooklist.add(PhoneBook(""+i+"번째 사람","010-0000-00"+i))
////        }
//
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//        phonebooklist.add(PhoneBook("1번째 사람","010-1"))
//
//
//
//        phonebooklist.forEach{ phoneBook ->
//            val phonebookItem=inflater.inflate(R.layout.phone_book_item,null)
////            val image =phonebookItem.findViewById<ImageView>(R.id.image_1)
//            val name = phonebookItem.findViewById<TextView>(R.id.name)
//            val number =  phonebookItem.findViewById<TextView>(R.id.number)
//
////            image.setImageDrawable(resources.getDrawable(R.drawable.ic_launcher_foreground,this.theme))
//            name.text = phoneBook.name
//            number.text = phoneBook.number
//
//            container.addView(phonebookItem)
//        }
//
//
    }
}


//class PhoneBook(val name:String, val number:String)