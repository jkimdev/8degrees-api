package com.jimmy.dao

import com.jimmy.models.PerformanceDAO

interface PerformanceDAOFacade {
    suspend fun findSinglePerformance(pid: String): List<PerformanceDAO>
    suspend fun findPerformanceByGenre(genre: String, offset: Int, limit: Int): List<PerformanceDAO>
    suspend fun findUpComingPerformance(offset: Int, limit: Int): List<PerformanceDAO>
    suspend fun findPerformanceByFacility(facilityId: String, offset: Int, limit: Int): List<PerformanceDAO>

//    suspend fun addNewPerformance(title: String, body: String): Performance?
//    suspend fun editPerformance(id: Int, title: String, body: String): Boolean
//    suspend fun deletePerformance(id: Int): Boolean
}