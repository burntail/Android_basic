package com.example.contentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.provider.BaseColumns
import android.util.Log


class MyContentProvider : ContentProvider() {

//    lateinit var feed_dbHelper: FeedReaderDbHelper

    override fun onCreate(): Boolean {

//        feed_dbHelper= context.let { FeedReaderDbHelper.getInstance(it) }
        return true
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {

        var feed_dbhelper= context?.let { FeedReaderDbHelper.getInstance(it) }
        Log.d("contentprovider_function_check_delete_part","${selection}")
        feed_dbhelper?.writableDatabase?.execSQL("DELETE FROM entry WHERE id = '${selection}'")
        return 0
    }


    override fun getType(uri: Uri): String? {
        return ""
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {

        var feed_dbhelper= context?.let { FeedReaderDbHelper.getInstance(it) }
        Log.d("contentprovider_function_check_insert_part","${values?.get("id")} , ${values?.get("stuff")}")
        feed_dbhelper?.writableDatabase?.execSQL("INSERT INTO entry VALUES('${values?.get("id")}','${values?.get("stuff")}')")

        return uri
    }


    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return context?.let { FeedReaderDbHelper.getInstance(it) }?.readableDatabase?.rawQuery("SELECT * FROM entry",null)
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {

        var feed_dbhelper= context?.let { FeedReaderDbHelper.getInstance(it) }
        Log.d("contentprovider_function_check_update_part","${values?.get("id")} , ${values?.get("stuff")}")
        feed_dbhelper?.writableDatabase?.execSQL("UPDATE entry SET stuff='${values?.get("stuff")}' WHERE id = '${values?.get("id")}'")


        return 0
    }
}