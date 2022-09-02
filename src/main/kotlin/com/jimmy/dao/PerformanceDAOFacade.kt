package com.jimmy.dao

import com.jimmy.models.PerformanceDAO

interface PerformanceDAOFacade {
    suspend fun allPerformances(): List<PerformanceDAO>
    suspend fun findPerformanceByGenre(genre: String): List<PerformanceDAO>
//    suspend fun addNewPerformance(title: String, body: String): Performance?
//    suspend fun editPerformance(id: Int, title: String, body: String): Boolean
//    suspend fun deletePerformance(id: Int): Boolean
}