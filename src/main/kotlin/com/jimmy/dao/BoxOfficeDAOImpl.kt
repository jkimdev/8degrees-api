package com.jimmy.dao

import com.jimmy.models.BoxOfficeDAO
import com.jimmy.models.BoxOffices
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class BoxOfficeDAOImpl: BoxOfficeDAOFacade {
    private fun resultRowToBoxOffice(row: ResultRow) = BoxOfficeDAO(
        performanceId = row[BoxOffices.performanceId],
        ranking = row[BoxOffices.ranking],
        title = row[BoxOffices.title],
        genre = row[BoxOffices.genre],
        poster = row[BoxOffices.poster],
    )

    override suspend fun allBoxOffices(): List<BoxOfficeDAO> = dbQuery {
        BoxOffices.selectAll().limit(5).orderBy(BoxOffices.ranking).map(::resultRowToBoxOffice)
    }
}