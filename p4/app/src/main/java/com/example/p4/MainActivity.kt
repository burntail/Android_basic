package com.example.p4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.zip.Inflater
import com.example.p4.ViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var car_list= mutableListOf<Car>()

//        for (i in 1..50){
//            car_list.add(Car(""+i+"th car",""+i+"th engine"))
//        }
        //어댑터 준비
        var layout=LayoutInflater.from(this@MainActivity)

        var adapter=CarBaseAdapter(car_list,layout)

        var car_list_=findViewById<ListView>(R.id.car_list)

        car_list_.adapter=adapter

        car_list_.setOnItemClickListener { parent, view, position, id ->
            var car:Car = adapter.car_list.get(position)
            var carname= car.name
            var carengine=car.engine

            Toast.makeText(this,carname+" "+carengine,Toast.LENGTH_SHORT).show()
        }

        var button_of_add_car=findViewById<TextView>(R.id.add_car_tab)

        button_of_add_car.setOnClickListener {
            var i=car_list.size
            adapter.car_list.add(Car(""+i+"th car",""+i+"th engine"))
            
            adapter.notifyDataSetChanged() // 위 데이터 변경 코드가 있기에 변경이 되었다는 것을 알려 줘야 함
        }






    }
}

class Car(var name:String,var engine:String)

class CarBaseAdapter(var car_list:MutableList<Car>,var layoutinflater:LayoutInflater):BaseAdapter(){
    override fun getCount(): Int {
        return car_list.size
    }

    override fun getItem(position: Int): Any {
        return car_list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // 재활용 가능한 코드를 만들어야 함 , 여기서 두번째 파라미터가 convertView가 존재를 하는데 이것은 재활용되는 뷰입니다(1번째가 사라지고 7번째가 나타날때 1번째가 재활용됩니다)

        var new_view : View
        var holder: ViewHolder

        if(convertView==null) // inflate가 된 적이 없음, 재활용 불가능
        {
            new_view=layoutinflater.inflate(R.layout.car_item,null) // inflate에 빨간 줄이 있으면 root(부모뷰):null로 왠만하면 설정
            holder= ViewHolder()
            holder.car_name=new_view.findViewById(R.id.car_name)
            holder.car_engine=new_view.findViewById(R.id.car_engine_number)

            new_view.tag=holder // 중요!


        }
        else { // 재활용 가능
            holder=convertView.tag as ViewHolder // animal as Dog
            new_view=convertView


        }

        var car=car_list.get(position)

        holder.car_name?.text=car.name
        holder.car_engine?.text=car.engine

        return new_view




        // 아래 코드는 데이터 개수 만큼 inflate를 해주어야 해서 리소스를 많이 잡아 먹음
//        var new_view=layoutinflater.inflate(R.layout.car_item,null)
//        var car_name_textview=new_view.findViewById<TextView>(R.id.car_name)
//        var car_engine_textview=new_view.findViewById<TextView>(R.id.car_engine_number)
//
//        var car=car_list.get(position)
//
//        car_name_textview.text=car.name
//        car_engine_textview.text=car.engine
//
//        return new_view
    }

}

class ViewHolder{
    var car_name:TextView?=null
    var car_engine:TextView?=null
}
