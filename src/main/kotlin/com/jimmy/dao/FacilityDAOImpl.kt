package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

class FacilityDAOImpl : FacilityDAOFacade {
    private fun resultRowToFacility(row: ResultRow) = FacilityDAO(
        facilityId = row[Facilities.facilityId],
        place = row[Facilities.place],
        telNo = row[Facilities.telNo],
        url = row[Facilities.url],
        address = row[Facilities.address],
        latitude = row[Facilities.latitude],
        longitude = row[Facilities.longitude],
        distance = 0.0,
    )

    override suspend fun findNearFacility(startDate: String, latitude: Double, longitude: Double): List<FacilityDAO> =
        dbQuery {

            var query = Facilities.innerJoin(Performances, { Performances.facilityId }, { Facilities.facilityId })
                .slice(
                    Facilities.facilityId,
                    Facilities.place,
                    Facilities.telNo,
                    Facilities.url,
                    Facilities.address,
                    Facilities.latitude,
                    Facilities.longitude,
                    Performances.performanceId
                )
                .selectAll()
                .groupBy(Facilities.facilityId)
                .map { row -> FacilityDAO(
                    facilityId = row[Facilities.facilityId],
                    place = row[Facilities.place],
                    telNo = row[Facilities.telNo],
                    url = row[Facilities.url],
                    address = row[Facilities.address],
                    latitude = row[Facilities.latitude],
                    longitude = row[Facilities.longitude],
                    distance = (6371 * acos(
                        cos(Math.toRadians(latitude)) * cos(Math.toRadians(row[Facilities.latitude])) * cos(
                            Math.toRadians(row[Facilities.longitude]) - Math.toRadians(longitude)
                        ) + sin(Math.toRadians(latitude)) * sin(Math.toRadians(row[Facilities.latitude]))
                    )),
                )}
            query.stream().toList().filter { it -> it.distance < 5 }
        }
}

class SubQueryExpression<T>(private val aliasQuery: QueryAlias) : Expression<T>() {
    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
        aliasQuery.describe(TransactionManager.current(), queryBuilder)
    }
}
