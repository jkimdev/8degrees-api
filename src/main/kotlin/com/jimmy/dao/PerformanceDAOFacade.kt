package com.jimmy.dao

import com.jimmy.models.PerformanceDAO
import com.jimmy.models.SinglePerformanceDAO

interface PerformanceDAOFacade {
    suspend fun allPerformances(): List<PerformanceDAO>
    suspend fun findPerformanceById(id: String): List<SinglePerformanceDAO>
//    suspend fun addNewPerformance(title: String, body: String): Performance?
//    suspend fun editPerformance(id: Int, title: String, body: String): Boolean
//    suspend fun deletePerformance(id: Int): Boolean
}