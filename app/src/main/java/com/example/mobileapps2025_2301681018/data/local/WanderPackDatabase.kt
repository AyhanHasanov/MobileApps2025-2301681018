package com.example.mobileapps2025_2301681018.data.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobileapps2025_2301681018.data.local.entity.BoardingPass
import com.example.mobileapps2025_2301681018.data.local.entity.ItineraryEvent
import com.example.mobileapps2025_2301681018.data.local.entity.PackingItem
import com.example.mobileapps2025_2301681018.data.local.entity.SavedPlace
import com.example.mobileapps2025_2301681018.data.local.entity.Trip
@Database(
    entities   = [
        Trip::class,
        PackingItem::class,
        ItineraryEvent::class,
        SavedPlace::class,
        BoardingPass::class
    ],
    version    = 1,
    exportSchema = false
)
abstract class WanderPackDatabase : RoomDatabase() {



    companion object {
        @Volatile
        private var INSTANCE: WanderPackDatabase? = null

        fun getInstance(context: Context): WanderPackDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    WanderPackDatabase::class.java,
                    "wanderpack_db"
                ).build().also { INSTANCE = it }
            }
    }
}