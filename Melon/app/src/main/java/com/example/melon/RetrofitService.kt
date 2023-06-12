package com.example.melon

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable


class MelonItem(val id:Int, val title:String, val song:String, val thumbnail:String):Serializable

interface RetrofitService {

    @GET("melon/list/")
    fun getMelonItemList(): Call<ArrayList<MelonItem>>
}