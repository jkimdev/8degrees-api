package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.*
import java.time.LocalDate

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
        startIdx: String,
        endIdx: String
    ): List<PerformanceDAO> =
        dbQuery {
            Performances
                .select {
                    (Performances.startDate greaterEq LocalDate.now().toString())
                }
                .orderBy(Performances.startDate)
                .limit(endIdx.toInt(), offset = startIdx.toLong())
                .map(::resultRowToPerformance)
        }

    override suspend fun findPerformanceByFacility(
        facilityId: String,
        startIdx: String,
        endIdx: String
    ): List<PerformanceDAO> = dbQuery {

        val count = Performances.select {
            (Performances.startDate eq LocalDate.now().toString()) and (Performances.facilityId eq facilityId)
        }.count()

        if (count > 1) {
            Performances.select {
                (Performances.startDate eq LocalDate.now().toString()) and (Performances.facilityId eq facilityId)
            }
                .limit(endIdx.toInt(), offset = startIdx.toLong())
                .map(::resultRowToPerformance)
        } else {
            Performances.select {
                (Performances.startDate eq LocalDate.now().toString()) and (Performances.facilityId eq facilityId)
            }
                .limit(endIdx.toInt())
                .map(::resultRowToPerformance)
        }
    }
}