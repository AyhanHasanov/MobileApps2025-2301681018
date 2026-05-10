package com.example.mobileapps2025_2301681018.data.local.entity
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "itinerary_events",
    foreignKeys = [ForeignKey(
        entity       = Trip::class,
        parentColumns = ["id"],
        childColumns  = ["tripId"],
        onDelete     = ForeignKey.CASCADE
    )],
    indices = [Index("tripId")]
)
data class ItineraryEvent(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tripId: Int,
    val dayDate: Long,                  // date normalised to midnight UTC
    val time: String? = null,           // "14:30" or null
    val title: String,
    val notes: String? = null,
    val linkedPlaceId: Int? = null     // soft link to SavedPlace
)