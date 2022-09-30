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
//        performance = Performances.innerJoin(Facilities, { Facilities.facilityId }, { Performances.facilityId })
//            .select { Performances.facilityId eq row[Facilities.facilityId] }
//            .map {
//                SimplePerformanceDAO(
//                    performanceId = it[Performances.performanceId],
//                    title = it[Performances.title],
//                    poster = it[Performances.poster],
//                    genre = it[Performances.genre],
//                    runtime = it[Performances.runtime],
//                    rating = it[Performances.rating],
//                    story = it[Performances.story],
//                )
//            },
        radius = 0.0
    )

    override suspend fun findNearFacility(startDate: String, latitude: Double, longitude: Double): List<FacilityDAO> =
        dbQuery {
           Facilities
                .selectAll()
                .limit(1)
                .map{ FacilityDAO(
                    facilityId = it[Facilities.facilityId],
                    place = it[Facilities.place],
                    telNo = it[Facilities.telNo],
                    url = it[Facilities.url],
                    address = it[Facilities.address],
                    latitude = it[Facilities.latitude],
                    longitude = it[Facilities.longitude],
                    radius = (6371 * acos(
                        cos(Math.toRadians(latitude)) * cos(Math.toRadians(it[Facilities.latitude])) * cos(
                            Math.toRadians(it[Facilities.longitude]) - Math.toRadians(longitude)
                        ) + sin(Math.toRadians(latitude)) * sin(Math.toRadians(it[Facilities.latitude]))
                    ))
//                    performance = Performances.innerJoin(Facilities, { Facilities.facilityId }, { Performances.facilityId })
//                        .select { Performances.facilityId eq it[Facilities.facilityId] }
//                        .map {it ->
//                            SimplePerformanceDAO(
//                                performanceId = it[Performances.performanceId],
//                                title = it[Performances.title],
//                                poster = it[Performances.poster],
//                                genre = it[Performances.genre],
//                                runtime = it[Performances.runtime],
//                                rating = it[Performances.rating],
//                                story = it[Performances.story],
//                            )
//                        }
                )}
        }
}

class SubQueryExpression<T>(private val aliasQuery : QueryAlias) : Expression<T>() {
    override fun toQueryBuilder(queryBuilder: QueryBuilder) {
        aliasQuery.describe(TransactionManager.current(), queryBuilder)
    }
}
