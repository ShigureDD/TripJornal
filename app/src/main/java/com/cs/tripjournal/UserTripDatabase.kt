package com.cs.tripjournal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserTrip::class], version = 3)
abstract class UserTripDatabase : RoomDatabase() {
    abstract fun userTripDao(): UserTripDao

    companion object {
        @Volatile private var instance: UserTripDatabase? = null
        private val LOCK = Any()

        @Synchronized fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            UserTripDatabase::class.java, "userTrip_database")
            .allowMainThreadQueries().build()
    }

}