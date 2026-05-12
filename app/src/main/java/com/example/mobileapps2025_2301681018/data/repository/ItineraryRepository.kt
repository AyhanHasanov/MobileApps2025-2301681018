package com.example.mobileapps2025_2301681018.data.repository

import com.example.mobileapps2025_2301681018.data.local.dao.ItineraryDao
import com.example.mobileapps2025_2301681018.data.local.entity.ItineraryEvent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ItineraryRepository @Inject constructor(
    private val dao: ItineraryDao
) {
    val allItineraryEvents: Flow<List<ItineraryEvent>> = dao.getAllEvents()

    fun getItineraryEventById(id: Int) = dao.getEventById(id)

    suspend fun insert(itineraryEvent: ItineraryEvent) = dao.insertEvent(itineraryEvent)
    suspend fun update(itineraryEvent: ItineraryEvent) = dao.updateEvent(itineraryEvent)
    suspend fun delete(itineraryEvent: ItineraryEvent) = dao.deleteEvent(itineraryEvent)
}