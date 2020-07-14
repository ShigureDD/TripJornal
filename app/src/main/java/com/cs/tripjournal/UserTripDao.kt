package com.cs.tripjournal

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserTripDao{

    @Query("SELECT * FROM usertrip")
    fun getAllUserTrips(): List<UserTrip>

    @Insert
    fun insertUserTrip(usertrip: UserTrip)

    @Update
    fun update(usertrip: UserTrip)

}