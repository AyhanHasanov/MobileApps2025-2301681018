package com.example.mobileapps2025_2301681018.data.repository

import com.example.mobileapps2025_2301681018.data.local.dao.PackingDao
import com.example.mobileapps2025_2301681018.data.local.entity.PackingItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PackingRepository @Inject constructor(
    private val dao: PackingDao
) {
    val allPackingItems: Flow<List<PackingItem>> = dao.getAllPackingItems()

    fun getPackingItemById(id: Int) = dao.getPackingItemById(id)

    suspend fun insert(packingItem: PackingItem) = dao.insertPackingItem(packingItem)
    suspend fun update(packingItem: PackingItem) = dao.updatePackingItem(packingItem)
    suspend fun delete(packingItem: PackingItem) = dao.deletePackingItem(packingItem)
}