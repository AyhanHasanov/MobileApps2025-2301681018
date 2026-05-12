package com.example.mobileapps2025_2301681018.data.repository
import com.example.mobileapps2025_2301681018.data.local.dao.TripDao
import com.example.mobileapps2025_2301681018.data.local.entity.Trip
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TripRepository @Inject constructor(
    private val dao: TripDao
) {
    val allTrips: Flow<List<Trip>> = dao.getAllTrips()

    fun getTripById(id: Int) = dao.getTripById(id)

    suspend fun insert(trip: Trip) = dao.insertTrip(trip)
    suspend fun update(trip: Trip) = dao.updateTrip(trip)
    suspend fun delete(trip: Trip) = dao.deleteTrip(trip)
}