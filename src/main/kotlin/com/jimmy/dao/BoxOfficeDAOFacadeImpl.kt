package com.jimmy.dao

import com.jimmy.models.BoxOfficeDAO
import com.jimmy.models.BoxOffices
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class BoxOfficeDAOFacadeImpl: BoxOfficeDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = BoxOfficeDAO(
        performance_id = row[BoxOffices.performance_id],
        title = row[BoxOffices.title],
        ranking = row[BoxOffices.ranking]
    )

    override suspend fun allBoxOffices(): List<BoxOfficeDAO> = dbQuery {
        BoxOffices.selectAll().limit(5).orderBy(BoxOffices.ranking).map(::resultRowToPerformance)
    }
}