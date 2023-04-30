package com.example.p2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
//import com.example.p2.databinding.ActivityCalculationBinding
import kotlin.properties.Delegates

class CalculationActivity : AppCompatActivity() {

    lateinit var text_0: TextView
    lateinit var text_1: TextView
    lateinit var text_2: TextView
    lateinit var text_3: TextView
    lateinit var text_4: TextView
    lateinit var text_5: TextView
    lateinit var text_6: TextView
    lateinit var text_7: TextView
    lateinit var text_8: TextView
    lateinit var text_9: TextView
    lateinit var text_plus: TextView
    lateinit var text_minus: TextView
    lateinit var text_multiple: TextView
    lateinit var text_divide: TextView
    lateinit var text_AC: TextView
    lateinit var text_main_activity: TextView
    lateinit var text_main_equal: TextView
    lateinit var text_showed: TextView
    var temp: Int = 0
    var cal: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)

        Log.d("calculation_Lifecycle", "calculation activity onCreation")

        calculation_findViews() // view binding 으로도 충분히 가능
        //  binding example

//        val binding = ActivityCalculationBinding.inflate(layoutInflater)
//        binding.calculation0=???

    }

    private fun calculation_findViews() {
        text_0 = findViewById(R.id.calculation_0)
        text_1 = findViewById(R.id.calculation_1)
        text_2 = findViewById(R.id.calculation_2)
        text_3 = findViewById(R.id.calculation_3)
        text_4 = findViewById(R.id.calculation_4)
        text_5 = findViewById(R.id.calculation_5)
        text_6 = findViewById(R.id.calculation_6)
        text_7 = findViewById(R.id.calculation_7)
        text_8 = findViewById(R.id.calculation_8)
        text_9 = findViewById(R.id.calculation_9)
        text_plus = findViewById(R.id.calculation_plus)
        text_minus = findViewById(R.id.calculation_minus)
        text_multiple = findViewById(R.id.calculation_multiple)
        text_divide = findViewById(R.id.calculation_divide)
        text_AC = findViewById(R.id.calculation_reset)
        text_main_activity = findViewById(R.id.calculation_gotomain)
        text_main_equal = findViewById(R.id.calculation_equal)
        text_showed = findViewById(R.id.calculation_showed)
    }


    override fun onStart() {
        super.onStart()

        Log.d("calculation_Lifecycle", "calculation activity onStart")
    }

    override fun onResume() {
        super.onResume()


        Log.d("calculation_Lifecycle", "calculation activity onResume")

        //main activity로 가는 인텐트 및 액션 작동
        val gotomain_intent: Intent = Intent(this, MainActivity::class.java)

        gotomain_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // 그래야 뒤로 가기 많이 할 필요 없어짐

        text_main_activity.setOnClickListener {

            startActivity(gotomain_intent)
        }

        text_AC.setOnClickListener {
            temp = 0
            cal = ""
            text_showed.text = "0"

        }

        text_main_equal.setOnClickListener {

            do_calcuation()
            cal = ""
            text_showed.text = temp.toString()// show the result
        }

        text_plus.setOnClickListener {
            do_calcuation()
            cal = "+"
            text_showed.text = temp.toString()// show the result

        }

        text_minus.setOnClickListener {
            do_calcuation()
            cal = "-"
            text_showed.text = temp.toString()// show the result

        }

        text_multiple.setOnClickListener {
            do_calcuation()
            cal = "*"
            text_showed.text = temp.toString()// show the result

        }
        text_divide.setOnClickListener {
            do_calcuation()
            cal = "/"
            text_showed.text = temp.toString()// show the result

        }

        text_0.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 0
            text_showed.text = a.toString()

        }

        text_1.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 1
            text_showed.text = a.toString()
        }

        text_2.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 2
            text_showed.text = a.toString()
        }

        text_3.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 3
            text_showed.text = a.toString()
        }

        text_4.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 4
            text_showed.text = a.toString()
        }

        text_5.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 5
            text_showed.text = a.toString()
        }

        text_6.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 6
            text_showed.text = a.toString()
        }

        text_7.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 7
            text_showed.text = a.toString()
        }

        text_8.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 8
            text_showed.text = a.toString()
        }

        text_9.setOnClickListener {

            if (text_showed.text.toString() == temp.toString()) {
                text_showed.text = "0"
            }

            var a: Int = text_showed.text.toString().toInt()
            a *= 10
            a += 9
            text_showed.text = a.toString()
        }


    }

    private fun do_calcuation() {
        when (cal) {
            "+" -> {
                temp += text_showed.text.toString().toInt()

            }

            "-" -> {
                temp -= text_showed.text.toString().toInt()

            }

            "*" -> {
                temp *= text_showed.text.toString().toInt()

            }

            "/" -> {
                if (text_showed.text.toString() == "0") {
                    temp = text_showed.text.toString().toInt()
                } else {
                    temp /= text_showed.text.toString().toInt()
                }


            }

            else -> {
                temp = text_showed.text.toString().toInt()
            }

        }


    }

    override fun onPause() {
        super.onPause()


        Log.d("calculation_Lifecycle", "calculation activity onPause")
    }

    override fun onStop() {
        super.onStop()


        Log.d("calculation_Lifecycle", "calculation activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()


        Log.d("calculation_Lifecycle", "calculation activity onDestroy")
    }
}