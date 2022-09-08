package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.*

class PerformanceDAOImpl : PerformanceDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = PerformanceDAO(
        performanceId = row[Performances.performanceId],
        title = row[Performances.title],
        actor = (Actors innerJoin Performances).slice(Actors.name)
            .select { Performances.performanceId eq row[Performances.performanceId] }
            .map { ActorDAO(name = it[Actors.name]) },
        poster = row[Performances.poster],
        genre = row[Performances.genre]
    )

    override suspend fun findSinglePerformance(pid: String): List<PerformanceDAO> = dbQuery {
        (Actors innerJoin Performances).slice(
            Performances.performanceId,
            Performances.title,
            Performances.poster,
            Performances.genre
        )
            .select { Performances.performanceId eq pid }.groupBy(Performances.performanceId)
            .map(::resultRowToPerformance)
    }

    override suspend fun findPerformanceByGenre(genre: String, startIdx: String, endIdx: String): List<PerformanceDAO> =
        dbQuery {
            Performances.slice(
                Performances.performanceId,
                Performances.title,
                Performances.poster,
                Performances.genre
            )
                .select { Performances.genre eq genre }.limit(endIdx.toInt(), offset = startIdx.toLong())
                .map(::resultRowToPerformance)
        }
}