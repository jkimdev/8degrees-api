package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.*

class PerformanceDAOImpl : PerformanceDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = PerformanceDAO(
        performanceId = row[Performances.performanceId],
        facilityId = row[Performances.facilityId],
        title = row[Performances.title],
        poster = row[Performances.poster],
        story = row[Performances.story],
        actor = (Actors innerJoin Performances).slice(Actors.name)
            .select { Performances.performanceId eq row[Performances.performanceId] }
            .map { ActorDAO(name = it[Actors.name]) },
        genre = row[Performances.genre],
        rating = row[Performances.rating],
        startDate = row[Performances.startDate],
        endDate = row[Performances.endDate],
        state = row[Performances.state],
        runtime = row[Performances.runtime],
    )

    override suspend fun findSinglePerformance(pid: String): List<PerformanceDAO> = dbQuery {
        (Actors innerJoin Performances)
            .select { Performances.performanceId eq pid }.groupBy(Performances.performanceId)
            .map(::resultRowToPerformance)
    }

    override suspend fun findPerformanceByGenre(genre: String, startIdx: String, endIdx: String): List<PerformanceDAO> =
        dbQuery {
            Performances
                .select { Performances.genre eq genre }.limit(endIdx.toInt(), offset = startIdx.toLong())
                .map(::resultRowToPerformance)
        }

    override suspend fun findUpComingPerformance(
        startDate: String,
        startIdx: String,
        endIdx: String
    ): List<PerformanceDAO> =
        dbQuery {
            Performances
                .select { (Performances.startDate greaterEq startDate) and (Performances.state eq "ONGOING") }
                .orderBy(Performances.startDate)
                .limit(endIdx.toInt(), offset = startIdx.toLong())
                .map(::resultRowToPerformance)
        }

    override suspend fun findPerformanceByFacility(
        facilityId: String,
        startDate: String,
        startIdx: String,
        endIdx: String
    ): List<PerformanceDAO> = dbQuery {
        Performances.select { (Performances.facilityId eq facilityId) and (Performances.state eq "ONGOING") }
            .map(::resultRowToPerformance)
    }
}