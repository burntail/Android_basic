package com.example.contentprovider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


private const val SQL_CREATE_ENTRIES =
    "CREATE TABLE ${FeedReaderContract.FeedEntry.TABLE_NAME} (" +
            "${FeedReaderContract.FeedEntry.ID} INTEGER PRIMARY KEY," +
            "${FeedReaderContract.FeedEntry.STUFF} TEXT)"

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedReaderContract.FeedEntry.STUFF}"

object FeedReaderContract {
    // Table contents are grouped together in an anonymous object.
    object FeedEntry : BaseColumns {
        const val TABLE_NAME = "entry"
        const val ID = "id"
        const val STUFF = "stuff"
    }
}

class FeedReaderDbHelper(context: Context,filename:String) : SQLiteOpenHelper(context, "FeedReader.db", null, 1) {

    private var saveNum=0

    // Singleton
    companion object {
        var dbhelper: FeedReaderDbHelper? = null
        fun getInstance(context: Context):FeedReaderDbHelper {
            if (dbhelper == null) {
                dbhelper = FeedReaderDbHelper(context,"FeedReader.db")
            }
            return dbhelper!!
        }

    }


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }


    fun insert(tar:element):String{

        var db=this.writableDatabase
        db.execSQL("INSERT INTO entry VALUES('${tar.id}','${tar.stuff}')")

        return ""
    }

    fun delete(tar:element):Int{
        var db=this.writableDatabase
        db.execSQL(" DELETE FROM entry WHERE id = " +"  '${tar.id}' ")

        return tar.id
    }


}