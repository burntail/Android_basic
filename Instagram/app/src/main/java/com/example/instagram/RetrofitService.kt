package com.example.instagram

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable


//class MelonItem(val id:Int, val title:String, val song:String, val thumbnail:String):Serializable

class Token(
    val id:Int,
    val token:String
):Serializable

class UserToken(
    val id:Int,
    val username:String,
    val token:String
):Serializable


class Owner_profile(val id:Int,val username: String,val image:String,val user:Int):Serializable // image는 주소로 전달됨
class  InstaPost(val id:Int,val created:String,val content:String,val image: String,val like_count:Int,val owner_profile:Owner_profile):Serializable

interface RetrofitService {

    //@Body 설명
    //서버에서는 유일한 매개 변수로 받고, 클라이언트에서 Java  Object를 통째로 직렬화 해서 보낼때 사용
    //Java Object를 직렬화해서 보낼 수 있는것은, Retrofit이 Gson 컨버터와 함께 쓰이기 때문
    //@Body RequestPut parameters : 통신을 통해 전송하는 값이 특정 JSON 형식일 때 그러한 형태를 매번 만들지 않고 객체를 통해서 넘겨주는 방식입니다.
    //이러한 방식에서는 @Body라는 Annotation을 사용합니다. (PUT뿐만 아니라 다른 통신 방식에서도 마찬가지로 사용가능합니다)
    //즉 내가 만든 객체를 Json형식으로 넘겨줄때 밑과같은 Json형식처럼 넘겨주고 싶을 때 간편하게 사용할 수 있다. ( 쉽게말하면 그냥 객체쉽게 json 형식으로 보낼때 사용한다고 생각)

    //@
    @POST("user/login/")
    @FormUrlEncoded //
    fun instaLogin(
        @FieldMap params: HashMap<String,Any>
    ):Call<Token>


    @POST("user/signup/")
    @FormUrlEncoded
    fun instaJoin(
        @FieldMap params: HashMap<String,Any>
    ):Call<UserToken>

    @GET("instagram/post/list/all/")
    fun getInstagramPost():Call<ArrayList<InstaPost>>


}