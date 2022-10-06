package com.jimmy.dao

import com.jimmy.models.FacilityDAO

interface FacilityDAOFacade {
    suspend fun findNearFacility(latitude: Double, longitude: Double): List<FacilityDAO>
}