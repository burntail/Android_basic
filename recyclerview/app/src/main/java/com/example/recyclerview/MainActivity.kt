package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var car_list= mutableListOf<Car>()

        for (i in 1..30){
            car_list.add(Car(""+i+"th car",""+i+"th engine"))

        }

        findViewById<RecyclerView>(R.id.car_recycler_view).adapter= RecyclerViewAdapter(car_list, LayoutInflater.from(this@MainActivity))

        //내려 받은 뷰를 어떻게 배치를 할 건지 결정하는 매니저
        findViewById<RecyclerView>(R.id.car_recycler_view).layoutManager= LinearLayoutManager(this@MainActivity)


    }
}

//class RecyclerView_Adapter(var Car_list:MutableList<Car>,var inflater:LayoutInflater ):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//    class ViewHolder(caritem_view: View):RecyclerView.ViewHolder(caritem_view){
//        var carname_textview:TextView
//        var carengine_textview:TextView
//        init {
//            carname_textview=caritem_view.findViewById(R.id.car_name)
//            carengine_textview=caritem_view.findViewById(R.id.car_engine)
//
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//
//        //car_item 이라는 뷰를 리턴
//        var view=inflater.inflate(R.layout.car_item,parent,false)
//        return RecyclerView_Adapter.ViewHolder(view)
//
//
//    }
//
//
//    override fun getItemCount(): Int {
//        return Car_list.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.carname_textview.text=Car_list.get(position).car_name
//        holder.carengine_textview.text=Car_list.get(position).car_engine
//    }
//}

class RecyclerViewAdapter(var Car_list:MutableList<Car>, var inflater:LayoutInflater):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){ // 무조건 대소문자 고려해서 "ViewHolder"로 입력 해야 onBindViewHolder에 제대로 파싱됨 -> holder:ViewHolder
        var carname_textview:TextView
        var carengine_textview:TextView
        init {
            carname_textview=itemview.findViewById(R.id.car_name)
            carengine_textview=itemview.findViewById(R.id.car_engine)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view=inflater.inflate(R.layout.car_item,parent,false)
        return RecyclerViewAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Car_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carname_textview.text=Car_list.get(position).car_name
        holder.carengine_textview.text=Car_list.get(position).car_engine
    }


}

class Car(var car_name:String,var car_engine:String)