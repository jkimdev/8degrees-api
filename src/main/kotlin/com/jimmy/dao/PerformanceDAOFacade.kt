package com.jimmy.dao

import com.jimmy.models.PerformanceDAO

interface PerformanceDAOFacade {
    suspend fun findSinglePerformance(pid: String): List<PerformanceDAO>
    suspend fun findPerformanceByGenre(genre: String, startIdx: String, endIdx: String): List<PerformanceDAO>
    suspend fun findUpComingPerformance(startIdx: String, endIdx: String): List<PerformanceDAO>
    suspend fun findPerformanceByFacility(facilityId: String, startIdx: String, endIdx: String): List<PerformanceDAO>

//    suspend fun addNewPerformance(title: String, body: String): Performance?
//    suspend fun editPerformance(id: Int, title: String, body: String): Boolean
//    suspend fun deletePerformance(id: Int): Boolean
}