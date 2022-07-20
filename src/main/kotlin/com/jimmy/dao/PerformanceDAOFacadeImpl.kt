package com.jimmy.dao

import com.jimmy.models.Performance_tb
import com.jimmy.models.PerformanceDAO
import org.jetbrains.exposed.sql.*

class PerformanceDAOFacadeImpl : PerformanceDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = PerformanceDAO(
        performance_id = row[Performance_tb.performance_id],
        title = row[Performance_tb.title],
    )

    override suspend fun allPerformances(): List<PerformanceDAO> = dbQuery {
        Performance_tb.selectAll().map(::resultRowToPerformance)
    }
}