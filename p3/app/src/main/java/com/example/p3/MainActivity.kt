package com.example.p3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inflater=LayoutInflater.from(this)

        val CarList=ArrayList<Car>()
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))
        CarList.add(Car("carname","carengine"))

        val container=findViewById<LinearLayout>(R.id.container)

        for (car in CarList) {
            val CarView=inflater.inflate(R.layout.caritem,null)

            val carnameview=CarView.findViewById<TextView>(R.id.car_name)
            val carengineview=CarView.findViewById<TextView>(R.id.car_engine)

            carnameview.text=car.name
            carengineview.text=car.engine

            container.addView(CarView)

        }






    }
}

class Car(val name:String,val engine:String)