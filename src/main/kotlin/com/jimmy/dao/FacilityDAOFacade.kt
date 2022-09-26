package com.jimmy.dao

import com.jimmy.models.FacilityDAO

interface FacilityDAOFacade {
    suspend fun findNearPerformance(startDate: String, latitude: Double, longitude: Double): List<FacilityDAO>
}