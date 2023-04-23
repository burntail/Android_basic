package com.example.p2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    //var text_1 : TextView =findViewById(R.id.main_top_middle) --> 미리 여기서 작성하면 x -> 에러떠서 실행이 안됨
    lateinit var text_1 : TextView
    lateinit var text_2 : TextView
    lateinit var text_3 : TextView
    lateinit var text_4 : TextView
    lateinit var text_5 : TextView
    lateinit var text_6 : TextView
    lateinit var text_7 : TextView
    lateinit var text_8 : TextView
    lateinit var text_9 : TextView
//    var text_2:TextView = findViewById(R.id.main_top_middle)
//    var text_3:TextView = findViewById(R.id.main_top_right)
//    var text_4:TextView = findViewById(R.id.main_middle_left)
//    var text_5:TextView = findViewById(R.id.main_middle_middle)
//    var text_6:TextView = findViewById(R.id.main_middle_right)
//    var text_7:TextView = findViewById(R.id.main_bottom_left)
//    var text_8:TextView = findViewById(R.id.main_bottom_middle)
//    var text_9:TextView = findViewById(R.id.main_bottom_right)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("main_Lifecycle","main activity onCreate")

        //Creation 부분은 데이터 적재 하는 부분
        findviews()

    }

    private fun findviews() {
        text_1=findViewById(R.id.main_top_left)
        text_2=findViewById(R.id.main_top_middle)
        text_3=findViewById(R.id.main_top_right)
        text_4=findViewById(R.id.main_middle_left)
        text_5=findViewById(R.id.main_middle_middle)
        text_6=findViewById(R.id.main_middle_right)
        text_7=findViewById(R.id.main_bottom_left)
        text_8=findViewById(R.id.main_bottom_middle)
        text_9=findViewById(R.id.main_bottom_right)
    }

    override fun onStart() {
        super.onStart()

        Log.d("main_Lifecycle","main activity onStart")
    }

    override fun onResume() {
        super.onResume()


        Log.d("main_Lifecycle", "main activity onResume")

//        val activity_list= listOf(CalculationActivity::class.java,Sub2Activity::class.java)
//        val button_list = listOf(text_1,text_2,text_3,text_4,text_5,text_6,text_7,text_8,text_9)
//
//        button_list.forEach {
//                text->text.setOnClickListener{
//            val go_intent = Intent(this,CalculationActivity::class.java)
//            startActivity(go_intent)
//        }

//        }
        text_1.setOnClickListener{
            val go_intent = Intent(this,CalculationActivity::class.java)
            startActivity(go_intent)
        }

    }

    override fun onPause() {
        super.onPause()


        Log.d("main_Lifecycle","main activity onPause")
    }

    override fun onStop() {
        super.onStop()


        Log.d("main_Lifecycle","main activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()


        Log.d("main_Lifecycle","main activity onDestroy")
    }


}