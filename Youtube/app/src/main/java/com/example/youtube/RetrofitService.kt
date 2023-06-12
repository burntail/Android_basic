package com.example.youtube

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

class Youtube(
    val id:Int, val title: String, val content: String, val video: String, val thumbnail: String
)


interface RetrofitService {
    @GET("youtube/list/")
    fun getYoutubeList():Call<ArrayList<Youtube>>
}