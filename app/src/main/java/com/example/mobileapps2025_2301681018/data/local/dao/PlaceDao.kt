package com.example.mobileapps2025_2301681018.data.local.dao
import androidx.room.*
import com.example.mobileapps2025_2301681018.data.local.entity.SavedPlace
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {

    // Returns a Flow — Room re-emits whenever the trips table changes
    @Query("SELECT * FROM saved_places")
    fun getAllSavedPlaces(): Flow<List<SavedPlace>>

    @Query("SELECT * FROM saved_places WHERE id = :savedPlaceId")
    fun getSavedPlaceById(savedPlaceId: Int): Flow<SavedPlace?>

    // suspend fun = must be called from a coroutine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedPlace(savedPlace: SavedPlace): Long  // returns new row id

    @Update
    suspend fun updateSavedPlace(savedPlace: SavedPlace)

    @Delete
    suspend fun deleteSavedPlace(savedPlace: SavedPlace)

    @Query("DELETE FROM saved_places WHERE id = :savedPlaceId")
    suspend fun deleteSavedPlaceById(savedPlaceId: Int)
}