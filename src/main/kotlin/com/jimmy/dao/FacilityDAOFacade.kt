package com.jimmy.dao

import com.jimmy.models.FacilityDAO

interface FacilityDAOFacade {
    suspend fun findNearFacility(startDate: String, latitude: Double, longitude: Double): List<FacilityDAO>
}