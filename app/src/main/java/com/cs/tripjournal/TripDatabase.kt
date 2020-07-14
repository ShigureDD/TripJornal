package com.cs.tripjournal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.security.AccessControlContext


@Database(entities = [Trip::class], version = 2)
abstract class TripDatabase : RoomDatabase() {
    abstract fun tripDao(): TripDao

    companion object {
        @Volatile
        private var INSTANCE: TripDatabase? = null

        fun getInstance(context: Context): TripDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TripDatabase::class.java, "trip_database"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        getInstance(context).tripDao().insertTrip(Trip)
                        getInstance(context).tripDao().insertTrip(Trip2)
                    }
                })
                .allowMainThreadQueries()
                .build()



//        val Trips = listOf(Trip(
//            1,
//            "Hong Kong",
//            "Hong Kong comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
//            10,
//            R.drawable.hongkong,
//            40.730610,
//            -73.935242
//        ),
//        Trip(
//            2,
//            "New York",
//            "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
//            10,
//            R.drawable.newyork,
//            40.730610,
//            -73.935242
//        ))
        val Trip = Trip(
            1,
            "Hong Kong",
            "Hong Kong comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
            10,
             R.drawable.hongkong,
            40.730610,
            -73.935242
        )
            val Trip2= Trip(
            2,
            "New York",
            "New York City comprises 5 boroughs sitting where the Hudson River meets the Atlantic Ocean. At its core is Manhattan, a densely populated borough that’s among the world’s major commercial, financial and cultural centers. Its iconic sites include skyscrapers such as the Empire State Building and sprawling Central Park. Broadway theater is staged in neon-lit Times Square.",
            10,
             R.drawable.newyork,
            40.730610,
            -73.935242
        )
    }
}