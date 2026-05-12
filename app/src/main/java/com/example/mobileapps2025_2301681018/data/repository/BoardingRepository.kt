package com.example.mobileapps2025_2301681018.data.repository

import com.example.mobileapps2025_2301681018.data.local.dao.BoardingPassDao
import com.example.mobileapps2025_2301681018.data.local.entity.BoardingPass
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class BoardingRepository @Inject constructor(
    private val dao: BoardingPassDao
) {
    val allBoardingPasses: Flow<List<BoardingPass>> = dao.getAllBoardingPasses()

    fun getBoardingPassById(id: Int) = dao.getBoardingPassById(id)

    suspend fun insert(boardingPass: BoardingPass) = dao.insertBoardingPass(boardingPass)
    suspend fun update(boardingPass: BoardingPass) = dao.updateBoardingPass(boardingPass)
    suspend fun delete(boardingPass: BoardingPass) = dao.deleteBoardingPass(boardingPass)
}