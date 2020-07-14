package com.cs.tripjournal

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity
data class Trip(
    @PrimaryKey val tid: Int = 0,
    val cityName: String?,
    val description: String?,
    val popularity: Int?,
    val photo: Int,
    val latitude: Double,
    val longitude: Double
)