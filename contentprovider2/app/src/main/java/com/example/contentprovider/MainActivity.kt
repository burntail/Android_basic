package com.example.contentprovider

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    // Create a new map of values, where column names are the keys
    object FeedReaderContract {
        // Table contents are grouped together in an anonymous object.
        object FeedEntry : BaseColumns {
            const val TABLE_NAME = "entry"
            const val ID = "id"
            const val STUFF = "stuff"
        }
    }



    lateinit var dbHelper : FeedReaderDbHelper
    private var saveNum=0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dbHelper=FeedReaderDbHelper.getInstance(applicationContext)

        val saveNumSet=dbHelper.readableDatabase
        val cursor = saveNumSet.rawQuery("SELECT * FROM entry",null)

        if(cursor.moveToLast()){
            saveNum=cursor.getInt(0)+1
        }

        // 새로운 내용 저장
        findViewById<Button>(R.id.insert_button).setOnClickListener{
//            val datalist=dbHelper.writableDatabase
//            datalist.execSQL("INSERT INTO entry VALUES('$saveNum','"+findViewById<EditText>(R.id.stuff_blank).text+"')")
//            saveNum+=1



            val newValue=ContentValues().apply {
                put(cursor.getColumnName(0),saveNum)
                put(cursor.getColumnName(1),"${findViewById<EditText>(R.id.stuff_blank).text}")
            }
            val newUri=contentResolver.insert(Uri.parse("content://com.example.contentprovider.data"),newValue)

            saveNum+=1
            read()

        }

        // 특정 부분 내용 수정
        findViewById<Button>(R.id.update_button).setOnClickListener{
//            val datalist=dbHelper.writableDatabase
//            datalist.execSQL("UPDATE entry SET stuff='"+findViewById<EditText>(R.id.stuff_blank).text+"' WHERE id = '"+findViewById<EditText>(R.id.number_blank).text+"'")
//            read()

            val new_value=ContentValues().apply {
                put(cursor.getColumnName(0),"${findViewById<EditText>(R.id.number_blank).text}")
                put(cursor.getColumnName(1),"${findViewById<EditText>(R.id.stuff_blank).text}")
            }
            val new_int=contentResolver.update(Uri.parse("content://com.example.contentprovider.data"),new_value,null,null)

            read()
        }

        // 데이터 삭제
        findViewById<Button>(R.id.delete_button).setOnClickListener{
//            val datalist=dbHelper.writableDatabase
//
//            datalist.execSQL("DELETE FROM entry WHERE id ='"+findViewById<EditText>(R.id.number_blank).text+"'")
//
            val new_int=contentResolver.delete(Uri.parse("content://com.example.contentprovider.data"),"${findViewById<EditText>(R.id.number_blank).text}",null)

            read()
        }



    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

    private fun read(){
        val db=dbHelper.readableDatabase
        val cursor=db.rawQuery("SELECT * FROM entry",null)



        findViewById<TextView>(R.id.list_up).text=""

        while (cursor.moveToNext()){
            findViewById<TextView>(R.id.list_up).text=""+findViewById<TextView>(R.id.list_up).text+"ID : "+cursor.getString(0)+" value: "+cursor.getString(1)+"\n"
        }


    }
}

