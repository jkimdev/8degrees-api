package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class PerformanceDAOImpl : PerformanceDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = PerformanceDAO(
        performanceId = row[Performances.performanceId],
        title = row[Performances.title],
        actor = (Actors innerJoin Performances).slice(Actors.name)
            .select { Performances.performanceId eq row[Performances.performanceId] }
            .map { ActorDAO(name = it[Actors.name]) })

    private fun resultRowToSinglePerformance(row: ResultRow) = SinglePerformanceDAO(
        performanceId = row[Performances.performanceId],
        title = row[Performances.title],
        poster = row[Performances.poster]
    )

    override suspend fun allPerformances(): List<PerformanceDAO> = dbQuery {
        (Actors innerJoin Performances).slice(Performances.performanceId, Performances.title, Actors.name)
            .select { Actors.performanceId eq Performances.performanceId }.groupBy(Performances.performanceId)
            .map(::resultRowToPerformance)
    }

    override suspend fun findPerformanceById(id: String): List<SinglePerformanceDAO> = dbQuery {
        Performances.slice(Performances.performanceId, Performances.title, Performances.poster)
            .select { Performances.performanceId eq id }
            .map(::resultRowToSinglePerformance)
    }
}