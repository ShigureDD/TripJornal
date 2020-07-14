package com.cs.tripjournal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserTrip(
    @PrimaryKey(autoGenerate = true) val tid: Int = 0,
    val cityName: String?,
    val description: String?,
    val popularity: Int?,
    val photo: Int,
    val latitude: Double,
    val longitude: Double
)