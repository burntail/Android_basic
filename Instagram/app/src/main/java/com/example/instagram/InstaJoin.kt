package com.example.instagram

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaJoin : AppCompatActivity() {

    var new_username:String=""
    var new_password:String=""
    var new_password_check:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_join)



        findViewById<TextView>(R.id.goto_login_activity).setOnClickListener {
            startActivity(Intent(this@InstaJoin,InstaLogin::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }

        findViewById<EditText>(R.id.enroll_ID_blank).doAfterTextChanged {
            new_username=it.toString()
        }
        findViewById<EditText>(R.id.enroll_Password_blank).doAfterTextChanged {
            new_password=it.toString()

        }
        findViewById<EditText>(R.id.enroll_Password_check_blank).doAfterTextChanged {
            new_password_check=it.toString()

        }



        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService=retrofit.create(RetrofitService::class.java)

        findViewById<TextView>(R.id.enroll_new_account_button).setOnClickListener {
            val user=HashMap<String,Any>()
            user.put("username",new_username)
            user.put("password1",new_password)
            user.put("password2",new_password_check)

            if(new_password!=new_password_check){
                val toast:Toast=Toast.makeText(this@InstaJoin,"Differenct password!"+"\n"+ "please check again!",Toast.LENGTH_LONG)
                toast.show()
            }
            else{

                retrofitService.instaJoin(user).enqueue(object : Callback<UserToken>{
                    override fun onResponse(call: Call<UserToken>, response: Response<UserToken>) {
                        if (response.isSuccessful){
                            Log.d("insta_join","Insta Join success: ${response.body()?.id}, ${response.body()?.username}, ${response.body()?.token}")

                            val userToken=response.body()!!
//                            - getSharedPreferences(String name, int mode)
//                            -> 위 함수를 통하여 SharedPrefrences 객체를 받아 올수 있습니다.
//                            -> 첫번째 인자  name은 해당 SharedPreferences의 이름입니다. 특정 이름으로 생성할수 있고 해당 이름으로 xml 파일이 생성된다고 생각하시면 됩니다.
//                            -> 두번째 인자 mode는 읽고 쓰기 권한 관련된 Mode라고 생각하시면 됩니다.

//                            mode 종류
//                            MODE_PRIVATE : 해당 앱에서만 읽기, 쓰기 가능
//                            MODE_WORLD_READABLE : 다른 앱에서 읽기 가능
//                            MODE_WORLD_WRITEABLE : 다른 앱에서 쓰기 가능
//                            MODE_MULTI_PROCESS : 다른 앱에서 읽기와 쓰기 가능

                            val sharedPreferences=getSharedPreferences("user_info", Context.MODE_PRIVATE)

//
//                            공유 환경설정 파일을 쓰기 위해서는 sharedPreference에서 edit()을 호출해야 함(Android studio)
//                            참고: SharedPreferences 객체가 아닌 EncryptedSharedPreferences 객체에서 edit() 메서드를 호출하여 공유 환경설정을 더 안전하게 수정할 수 있습니다. 자세한 내용은 더 안전하게 데이터를 사용하는 방법에 관한 가이드를 참고하세요.

                            val editor: SharedPreferences.Editor = sharedPreferences.edit()

//                            putInt() 및 putString()과 같은 메서드를 사용하여 쓰려고 하는 키와 값을 전달합니다. 그런 다음 apply() 또는 commit()을 호출하여 변경사항을 저장합니다. 예를 들면 다음과 같습니다.
//                            apply()는 메모리 내 SharedPreferences 객체를 즉시 변경하지만 업데이트를 디스크에 비동기적으로 씁니다. 또는 commit()을 사용하여 데이터를 디스크에 동기적으로 쓸 수 있습니다. 그러나 commit()은 동기적이므로 기본 스레드에서 호출하는 것을 피해야 합니다. UI 렌더링이 일시중지될 수 있기 때문
                            editor.putString("token",userToken.token)
                            editor.putString("token",userToken.id.toString())
                            editor.commit()

                            val toast:Toast=Toast.makeText(this@InstaJoin,"New account made complete!",Toast.LENGTH_LONG)
                            toast.show()



                        }
                    }

                    override fun onFailure(call: Call<UserToken>, t: Throwable) {
                        Log.d("insta_join","Insta Join fail: ${t.message}")
                    }
                })
            }

        }

    }
}
