package com.example.mobileapps2025_2301681018.data.local.entity
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "saved_places",
    foreignKeys = [ForeignKey(
        entity       = Trip::class,
        parentColumns = ["id"],
        childColumns  = ["tripId"],
        onDelete     = ForeignKey.CASCADE
    )],
    indices = [Index("tripId")]
)
data class SavedPlace(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tripId: Int,
    val name: String,
    val lat: Double,
    val lng: Double,
    val category: String,               // "Restaurant", "Museum", etc.
    val googlePlaceId: String? = null, // from Places API if available
    val notes: String? = null,
    val addedAt: Long = System.currentTimeMillis()
)