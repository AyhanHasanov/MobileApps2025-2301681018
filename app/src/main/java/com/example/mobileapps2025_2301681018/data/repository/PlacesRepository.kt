package com.example.mobileapps2025_2301681018.data.repository

import com.example.mobileapps2025_2301681018.data.local.dao.PlaceDao
import com.example.mobileapps2025_2301681018.data.local.entity.SavedPlace
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class PlacesRepository @Inject constructor(
    private val dao: PlaceDao
) {
    val allSavedPlaces: Flow<List<SavedPlace>> = dao.getAllSavedPlaces()

    fun getSavedPlaceById(id: Int) = dao.getSavedPlaceById(id)

    suspend fun insert(savedPlace: SavedPlace) = dao.insertSavedPlace(savedPlace)
    suspend fun update(savedPlace: SavedPlace) = dao.updateSavedPlace(savedPlace)
    suspend fun delete(savedPlace: SavedPlace) = dao.deleteSavedPlace(savedPlace)
}