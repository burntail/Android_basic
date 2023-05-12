package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

data class mosigai(val products: ArrayList<ProductFromServer>,val total:Int,val skip: Int, val limit: Int)

data class ProductFromServer(val id:Int, val title:String, val description:String, val price: Int, val rating: Float, val stock: Int, val brand: String,val category: String, val thumbnail: String, val images:Array<String>)


interface retrofitservie {

    @GET("products")
    fun getproductlist(): Call<mosigai>
}