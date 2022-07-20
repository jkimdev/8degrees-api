package com.jimmy.dao

import com.jimmy.models.BoxOfficeDAO
import com.jimmy.models.BoxOffice_tb
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.selectAll

class BoxOfficeDAOFacadeImpl: BoxOfficeDAOFacade {
    private fun resultRowToPerformance(row: ResultRow) = BoxOfficeDAO(
        performance_id = row[BoxOffice_tb.performance_id],
        title = row[BoxOffice_tb.title],
        ranking = row[BoxOffice_tb.ranking]
    )

    override suspend fun allBoxOffices(): List<BoxOfficeDAO> = dbQuery {
        BoxOffice_tb.selectAll().limit(5).orderBy(BoxOffice_tb.ranking).map(::resultRowToPerformance)
    }
}