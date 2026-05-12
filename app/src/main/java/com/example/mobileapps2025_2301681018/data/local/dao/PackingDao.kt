package com.example.mobileapps2025_2301681018.data.local.dao
import androidx.room.*
import com.example.mobileapps2025_2301681018.data.local.entity.PackingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface PackingDao {

    // Returns a Flow — Room re-emits whenever the trips table changes
    @Query("SELECT * FROM packing_items")
    fun getAllPackingItems(): Flow<List<PackingItem>>

    @Query("SELECT * FROM packing_items WHERE id = :packingItemId")
    fun getPackingItemById(packingItemId: Int): Flow<PackingItem?>

    // suspend fun = must be called from a coroutine
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPackingItem(packingItem: PackingItem): Long  // returns new row id

    @Update
    suspend fun updatePackingItem(packingItem: PackingItem)

    @Delete
    suspend fun deletePackingItem(packingItem: PackingItem)

    @Query("DELETE FROM packing_items WHERE id = :packingItemId")
    suspend fun deletePackingItemById(packingItemId: Int)
}