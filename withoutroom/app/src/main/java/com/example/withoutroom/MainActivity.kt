package com.example.withoutroom

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.provider.MediaStore
import android.widget.EditText
import android.widget.TextView
import java.lang.Integer.parseInt


private const val SQL_CREATE_ENTRIES =
    "CREATE TABLE ${MainActivity.FeedReaderContract.FeedEntry.TABLE_NAME} (" +
            "${MainActivity.FeedReaderContract.FeedEntry.ID} INTEGER PRIMARY KEY," +
            "${MainActivity.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE} TEXT)"

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${MainActivity.FeedReaderContract.FeedEntry.TABLE_NAME}"


class MainActivity : AppCompatActivity() {

    object FeedReaderContract {
        // Table contents are grouped together in an anonymous object.
        object FeedEntry : BaseColumns {
            const val TABLE_NAME = "entry"
            const val ID = "id"
            const val COLUMN_NAME_TITLE = "title"
        }
    }

    class FeedReaderDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(SQL_CREATE_ENTRIES)
        }
        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }
        override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            onUpgrade(db, oldVersion, newVersion)
        }
        companion object {
            // If you change the database schema, you must increment the database version.
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "FeedReader.db"
        }
    }

    private val dbHelper = FeedReaderDbHelper(this@MainActivity) // -> SQLite 데이터베이스를 생성하고 버전 관리를 담당하는 클래스

    private var saveNum=0


    //////////////////////////// LIFE CYCLE /////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveNumSet = dbHelper.readableDatabase // -> 데이터베이스를 읽기 구너한으로 접근할 수 있는 객체로 반환
        val cursor = saveNumSet.rawQuery("SELECT * FROM entry",null) // -> 'entry' 테이블의 모든 열을 검색하는 쿼리

        if(cursor.moveToLast()){
//            saveNum = parseInt(""+cursor.getString(0))+1
            saveNum=cursor.getInt(0)+1
        }

        //save
        findViewById<TextView>(R.id.save).setOnClickListener {

            val db = dbHelper.writableDatabase
            db.execSQL("INSERT INTO entry VALUES('$saveNum','"+findViewById<EditText>(R.id.edit2).text+"')")
            saveNum+=1
            read()


        }

        //update
        findViewById<TextView>(R.id.update).setOnClickListener {

            val db = dbHelper.writableDatabase
            db.execSQL("UPDATE entry SET title='"+findViewById<EditText>(R.id.edit2).text+"' WHERE id='"+findViewById<EditText>(R.id.edit1).text+"'")

            read()


        }

        //delete
        findViewById<TextView>(R.id.delete).setOnClickListener {

            val db = dbHelper.writableDatabase
            db.execSQL("DELETE FROM entry WHERE id ='"+findViewById<EditText>(R.id.edit1).text+"'")

            read()


        }



    }
    private fun read(){
        val db = dbHelper.readableDatabase
        val cursor =db.rawQuery("SELECT * FROM entry",null)
        findViewById<TextView>(R.id.textview1).text=""

        while(cursor.moveToNext()){
            findViewById<TextView>(R.id.textview1).text=""+findViewById<TextView>(R.id.textview1).text+"ID : "+cursor.getString(0)+"Title : "+cursor.getString(1)+"\n"
        }
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }
}