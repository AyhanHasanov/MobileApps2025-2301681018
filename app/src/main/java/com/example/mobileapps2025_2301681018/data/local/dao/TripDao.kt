package com.example.mobileapps2025_2301681018.data.local.dao
import androidx.room.*
import com.example.mobileapps2025_2301681018.data.local.entity.Trip
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDao {

    // Returns a Flow — Room re-emits whenever the trips table changes
    @Query("SELECT * FROM trips ORDER BY startDate ASC")
    fun getAllTrips(): Flow<List<Trip>>

    @Query("SELECT * FROM trips WHERE id = :tripId")
    fun getTripById(tripId: Int): Flow<Trip?>

    // suspend fun = must be called from a coroutine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(trip: Trip): Long  // returns new row id

    @Update
    suspend fun updateTrip(trip: Trip)

    @Delete
    suspend fun deleteTrip(trip: Trip)

    @Query("DELETE FROM trips WHERE id = :tripId")
    suspend fun deleteTripById(tripId: Int)
}