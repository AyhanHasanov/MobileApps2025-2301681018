package com.example.mobileapps2025_2301681018.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "trips")
    data class Trip(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        val name: String,
        val destination: String,
        val startDate: Long,
        val endDate: Long,

        val accommodationName: String? = null,
        val accommodationAddress: String? = null,
        val accommodationLat: Double = 0.0,
        val accommodationLng: Double = 0.0,

        val notes: String? = null,
        val createdAt: Long = System.currentTimeMillis()
    )
