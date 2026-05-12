package com.example.mobileapps2025_2301681018.data.local.dao

import androidx.room.*
import com.example.mobileapps2025_2301681018.data.local.entity.ItineraryEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface ItineraryDao {

    @Query("SELECT * FROM itinerary_events")
    fun getAllEvents(): Flow<List<ItineraryEvent>>

    @Query("SELECT * FROM itinerary_events WHERE id = :itineraryEventId")
    fun getEventById(itineraryEventId: Int): Flow<ItineraryEvent?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(itineraryEvent: ItineraryEvent): Long

    @Update
    suspend fun updateEvent(itineraryEvent: ItineraryEvent)

    @Delete
    suspend fun deleteEvent(itineraryEvent: ItineraryEvent)

    @Query("DELETE FROM itinerary_events WHERE id = :eventId")
    suspend fun deleteEventById(eventId: Int)
}
