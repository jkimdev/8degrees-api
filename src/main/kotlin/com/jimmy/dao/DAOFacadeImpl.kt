package com.jimmy.dao

import com.jimmy.models.Performance
import com.jimmy.models.Performances
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*

class DAOFacadeImpl : DAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = Performance(
        mt20id = row[Performances.mt20id],
        prfnm = row[Performances.prfnm],
    )

    override suspend fun allPerformances(): List<Performance> = dbQuery {
        Performances.selectAll().map(::resultRowToPerformance)
    }
}