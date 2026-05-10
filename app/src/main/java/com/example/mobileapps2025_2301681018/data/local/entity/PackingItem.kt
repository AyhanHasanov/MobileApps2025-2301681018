package com.example.mobileapps2025_2301681018.data.local.entity
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "packing_items",
    foreignKeys = [ForeignKey(
        entity = Trip::class,
        parentColumns = ["id"],
        childColumns = ["tripId"],
        onDelete = ForeignKey.CASCADE   // auto-deletes when trip deleted
    )],
    indices = [Index("tripId")]           // speeds up queries by tripId
)

data class PackingItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tripId: Int,
    val name: String,
    val category: String,               // "Documents", "Clothes", etc.
    val isChecked: Boolean = false,
    val quantity: Int = 1,
    val addedAt: Long = System.currentTimeMillis()
)