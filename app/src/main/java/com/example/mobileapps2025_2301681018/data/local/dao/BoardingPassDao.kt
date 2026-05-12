package com.example.mobileapps2025_2301681018.data.local.dao
import androidx.room.*
import com.example.mobileapps2025_2301681018.data.local.entity.BoardingPass
import kotlinx.coroutines.flow.Flow

@Dao
interface BoardingPassDao {

    // Returns a Flow — Room re-emits whenever the trips table changes
    @Query("SELECT * FROM boarding_passes")
    fun getAllBoardingPasses(): Flow<List<BoardingPass>>

    @Query("SELECT * FROM boarding_passes WHERE id = :boardingPassId")
    fun getBoardingPassById(boardingPassId: Int): Flow<BoardingPass?>

    // suspend fun = must be called from a coroutine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBoardingPass(boardingPass: BoardingPass): Long  // returns new row id

    @Update
    suspend fun updateBoardingPass(boardingPass: BoardingPass)

    @Delete
    suspend fun deleteBoardingPass(boardingPass: BoardingPass)

    @Query("DELETE FROM trips WHERE id = :tripId")
    suspend fun deleteTripById(tripId: Int)
}