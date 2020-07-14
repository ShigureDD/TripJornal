package com.cs.tripjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.my_trip_layout.view.*
import kotlinx.android.synthetic.main.trip_detail.*

class TripDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trip_detail)
//        val tid = intent.getStringExtra(TripAdapter.ViewHolder.TID)
        val description=  intent.getStringExtra(UserTripAdapter.ViewHolder.CITY_DESCRIPTION)
        CityDescrtiption.text = description

        val city = intent.getStringExtra(UserTripAdapter.ViewHolder.TRIP_CITY)
        CityName.text = city

        val cityphoto = intent.getIntExtra(UserTripAdapter.ViewHolder.CITY_PHOTO, 0)
        CityPhoto.setImageResource(cityphoto)
        val citylongitude =intent.getDoubleExtra(UserTripAdapter.ViewHolder.CITY_LONGITUDE,0.0)
        val citylatitude =intent.getDoubleExtra(UserTripAdapter.ViewHolder.CITY_LATITUDE,0.0)
        CityPhoto.setOnClickListener {
                var intentP=Intent(this@TripDetailView,  CountryPlace ::class.java)
                intentP.putExtra("CITY_LONGITUDE", citylongitude)
                intentP.putExtra("CITY_LATITUDE", citylatitude)
                intentP.putExtra("CITY_NAME",city)
                startActivity(intentP)
            }
    }
}
