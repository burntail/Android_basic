package com.example.contentresolver

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 특정 부분 내용 수정
        findViewById<Button>(R.id.update_button).setOnClickListener{
//            val datalist=dbHelper.writableDatabase
//            datalist.execSQL("UPDATE entry SET stuff='"+findViewById<EditText>(R.id.stuff_blank).text+"' WHERE id = '"+findViewById<EditText>(R.id.number_blank).text+"'")
//            read()

            val cursor=contentResolver.query(Uri.parse("content://com.example.contentprovider.data/entry"),null,null,null,null)
//
//
//
            val new_value= ContentValues().apply {
                put(cursor?.getColumnName(0),"${findViewById<EditText>(R.id.number_blank).text}")
                put(cursor?.getColumnName(1),"${findViewById<EditText>(R.id.stuff_blank).text}")
            }
            val new_int=contentResolver.update(Uri.parse("content://com.example.contentprovider.data"),new_value,null,null)

            read()
        }

        // 데이터 삭제
        findViewById<Button>(R.id.delete_button).setOnClickListener {
//            val datalist=dbHelper.writableDatabase
//
//            datalist.execSQL("DELETE FROM entry WHERE id ='"+findViewById<EditText>(R.id.number_blank).text+"'")
//
//            val new_int = contentResolver.delete(
//                Uri.parse("content://com.example.contentprovider.data/entry"),
//                "${findViewById<EditText>(R.id.number_blank).text}",
//                null
//            )


            val new_int=contentResolver.delete(Uri.parse("content://com.example.contentprovider.data"),"${findViewById<EditText>(R.id.number_blank).text}",null)


            read()
        }


    }

    private fun read() {
        val cursor=contentResolver.query(Uri.parse("content://com.example.contentprovider.data"),null,null,null,null)



        findViewById<TextView>(R.id.list_up).text=""

        if (cursor != null) {
            while (cursor.moveToNext()){
                findViewById<TextView>(R.id.list_up).text=""+findViewById<TextView>(R.id.list_up).text+"ID : "+cursor.getString(0)+" value: "+cursor.getString(1)+"\n"
            }
        }
    }

}