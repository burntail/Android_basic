package com.example.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase






class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        기본적으로 데이터베이스 작업은 메인 쓰레드에서 할 수 없다
//        이유는 데이터베이스 작업을 휴대폰이 하는 동안 사용자가 기다려야 하기 때문
//        해결책은, 쓰레드를 이용하고 async를 이용하면 된다
        var userid:Int=1
        var database = Room.databaseBuilder(
            applicationContext,UserDatabase::class.java,"user-database"
        ).allowMainThreadQueries().build() // Main Thread에서 query를 받아 들이겠다

        findViewById<TextView>(R.id.save).setOnClickListener {
            val userProfile=UserProfile("hong","gildong")
            database.userProfileDao().insert(userProfile)
            Log.d("Room test","userProfile inserted")
        }

        findViewById<TextView>(R.id.load).setOnClickListener {
            val userProfiles=database.userProfileDao().getAll()
            userProfiles.forEach {
                Log.d("Room test","Room load"+it.id+" "+it.lastname+it.firstname)
            }


        }
        findViewById<TextView>(R.id.delete).setOnClickListener {

            database.userProfileDao().delete(userid)
            userid++
            Log.d("Room test","One userProfile deleted")

        }

    }
}

@Database(entities = [UserProfile::class],version=1) // version은 migration을 위해서 필요,
abstract class UserDatabase: RoomDatabase(){
    abstract fun userProfileDao():UserProfileDao


}


//Interface
@Dao
interface UserProfileDao{
    //CRUD -> 데이터베이스 조작
    //Query -> 데이터베이스 조회

    @Insert(onConflict = REPLACE) // ignore도 존재
    fun insert(userProfile :UserProfile)

    // ex) select * from youtube_ where id = 1;

    @Query("DELETE FROM userprofile WHERE id = :userId")
    fun delete(userId:Int)

    @Query("SELECT * FROM userprofile")
    fun getAll():List<UserProfile>

}

@Entity
class UserProfile(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="last_name") val lastname : String,
    @ColumnInfo(name="first_name") val firstname :String
    ){
    constructor(lastname: String,firstname: String,):this(0, lastname, firstname)
}

