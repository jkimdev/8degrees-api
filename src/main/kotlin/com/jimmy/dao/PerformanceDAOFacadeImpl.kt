package com.jimmy.dao

import com.jimmy.models.Performances
import com.jimmy.models.PerformanceDAO
import org.jetbrains.exposed.sql.*

class PerformanceDAOFacadeImpl : PerformanceDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = PerformanceDAO(
        performance_id = row[Performances.performance_id],
        title = row[Performances.title],
    )

    override suspend fun allPerformances(): List<PerformanceDAO> = dbQuery {
        Performances.selectAll().map(::resultRowToPerformance)
    }
}