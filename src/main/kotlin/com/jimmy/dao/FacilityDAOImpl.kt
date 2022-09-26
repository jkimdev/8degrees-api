package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class FacilityDAOImpl: FacilityDAOFacade {
    private fun resultRowToFacility(row: ResultRow) = FacilityDAO(
        facilityId = row[Facilities.facilityId],
        place = row[Facilities.place],
        telNo = row[Facilities.telNo],
        url = row[Facilities.url],
        address = row[Facilities.address],
        latitude = row[Facilities.latitude],
        longitude = row[Facilities.longitude],
    )

    override suspend fun findNearPerformance(startDate: String, latitude: Double, longitude: Double): List<FacilityDAO> = dbQuery {
        Facilities.selectAll().map(::resultRowToFacility)
    }
}
