package com.cs.tripjournal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.my_trip_layout.view.*


class AddTrip: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_trip)
        init()
    }
    fun init(){
        val sdb = Room.databaseBuilder(this, TripDatabase::class.java, "trip_database")
            .allowMainThreadQueries().build()

        val allTrip = sdb.tripDao().getAllTrips()
//        sdb.tripDao().insertTrip(Trip(
//            tid=0,
//            cityName = "New York",
//            description = "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
//            popularity = 10,
//            photo = R.drawable.newyork,
//            latitude =  40.730610,
//            longitude = -73.935242
//        ))
//        sdb.tripDao().insertTrip(Trip(
//            tid=1,
//            cityName = "HONG KONG",
//            description = "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
//            popularity = 10,
//            photo = R.drawable.hongkong,
//            latitude =  40.730610,
//            longitude = -73.935242
//        ))

        tripList.apply {
            layoutManager = LinearLayoutManager(this@AddTrip)
            adapter = TripAdapter(allTrip)
        }

    }


}