package com.jimmy.dao

interface FacilityDAOFacade {
    suspend fun findNearPerformance(startDate: String, latitude: String, longitude: String)
}