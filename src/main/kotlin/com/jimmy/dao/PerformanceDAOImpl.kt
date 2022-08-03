package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.*

class PerformanceDAOImpl : PerformanceDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = PerformanceDAO(
        performanceId = row[Performances.performanceId],
        title = row[Performances.title],
        actor = listOf(ActorDAO((row[Actors.name]))),
    )

    override suspend fun allPerformances(): List<PerformanceDAO> = dbQuery {
        (Actors innerJoin Performances)
            .slice(Performances.performanceId, Performances.title, Actors.name)
            .select { Actors.performanceId eq Performances.performanceId }
            .map(::resultRowToPerformance)
    }
}