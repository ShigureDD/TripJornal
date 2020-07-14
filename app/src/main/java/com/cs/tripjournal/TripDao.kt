package com.cs.tripjournal

import androidx.room.*

@Dao
interface TripDao{

    @Query("SELECT * FROM trip")
    fun getAllTrips(): List<Trip>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrip(trip: Trip)

    @Insert
    fun insertTripList(trip: List<Trip>)

    @Update
    fun update(trip: Trip)
}