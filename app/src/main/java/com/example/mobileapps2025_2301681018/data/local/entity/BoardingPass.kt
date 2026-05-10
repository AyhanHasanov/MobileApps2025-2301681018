package com.example.mobileapps2025_2301681018.data.local.entity
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "boarding_passes",
    foreignKeys = [ForeignKey(
        entity       = Trip::class,
        parentColumns = ["id"],
        childColumns  = ["tripId"],
        onDelete     = ForeignKey.CASCADE
    )],
    indices = [Index("tripId")]
)
data class BoardingPass(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tripId: Int,
    val passengerName: String,
    val airline: String,
    val flightNumber: String,
    val fromAirport: String,
    val toAirport: String,
    val departureTime: Long,
    val gate: String? = null,
    val seat: String? = null,
    val bookingRef: String? = null
)