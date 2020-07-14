package com.cs.tripjournal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sdb = Room.databaseBuilder(this, TripDatabase::class.java, "trip_database")
            .allowMainThreadQueries().build()
        sdb.tripDao().insertTrip(Trip(
            tid=0,
            cityName = "Hong Kong Disneyland",
            description = "Hong Kong Disneyland (Chinese: 香港迪士尼樂園) (also known as HK Disneyland or HKDL) is a theme park located on reclaimed land in Penny's Bay, Lantau Island. ... The park consists of seven themed areas: Main Street, U.S.A., Fantasyland, Adventureland, Tomorrowland, Grizzly Gulch, Mystic Point, and Toy Story Land.",
            popularity = 10,
            photo = R.drawable.dl,
            latitude =  22.3130 ,
            longitude = 114.0413
        ))
        sdb.tripDao().insertTrip(Trip(
            tid=1,
            cityName = "Hong Kong Ocean Park",
            description = "Ocean Park Hong Kong, commonly known as Ocean Park, is a marine mammal park, oceanarium, animal theme park and amusement park situated in Wong Chuk Hang and Nam Long Shan in the Southern District of Hong Kong. It is the second largest theme park in Hong Kong, after Hong Kong Disneyland.",
            popularity = 10,
            photo = R.drawable.op,
            latitude =  22.2467,
            longitude = 114.1757
        ))
        sdb.tripDao().insertTrip(Trip(
            tid=2,
            cityName = "The University of Hong Kong",
            description = "The University of Hong Kong is a public research university in Hong Kong. Founded in 1911, its origins trace back to the Hong Kong College of Medicine for Chinese, which was founded in 1887. It is the oldest tertiary institution in Hong Kong",
            popularity = 10,
            photo = R.drawable.hku,
            latitude =  22.2830,
            longitude = 114.1371
        ))
        sdb.tripDao().insertTrip(Trip(
            tid=3,
            cityName = "The Chinese University of Hong Kong",
            description = "The Chinese University of Hong Kong is a public research university in Shatin, Hong Kong formally established in 1963 by a charter granted by the Legislative Council of Hong Kong.",
            popularity = 10,
            photo = R.drawable.cu,
            latitude =  22.4196,
            longitude = 114.2068
        ))
        sdb.tripDao().insertTrip(Trip(
            tid=4,
            cityName = "Shek O",
            description = "The Shek O peninsula is a popular day trip destination. Quaint Shek O Village attracts sun seekers and families to its casual open-air eateries and its beach, dotted with barbecue pits. Hikers hit popular trails like the Dragon’s Back, in Shek O Country Park, or head to the more remote coastal cliffs of Cape d’Aguilar, to the south. Big Wave Bay is a known surf spot, and home to a prehistoric rock carving.",
            popularity = 10,
            photo = R.drawable.sho,
            latitude =  22.2334,
            longitude = 114.2420
        ))
        initViews();
    }

    private fun initViews() {
        setSupportActionBar(toolbar)
        val database = Room.databaseBuilder(this, UserTripDatabase::class.java, "userTrip_database").allowMainThreadQueries().build()
        var allUserTrip = database.userTripDao().getAllUserTrips()
        tripList.apply {
            // allUserTrip = database.userTripDao().getAllUserTrips()

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserTripAdapter(allUserTrip)
        }

        addTrip.setOnClickListener {
            //            database.userTripDao().insertUserTrip(UserTrip(
//                cityName = "New York",
//                description = "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
//                popularity = 10,
//                photo = R.drawable.newyork,
//                latitude =  40.730610,
//                longitude = -73.935242
//            ))

            val intent = Intent(this@MainActivity, AddTrip::class.java)
            this@MainActivity.startActivity(intent)

        }

    }

    override fun onResume() {
        super.onResume()
        initViews()
    }


}
