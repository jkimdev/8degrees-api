package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class BoxOfficeDAOImpl: BoxOfficeDAOFacade {
    private fun resultRowToBoxOffice(row: ResultRow) = BoxOfficeDAO(
        performanceId = row[BoxOffices.performanceId],
        ranking = row[BoxOffices.ranking],
        title = row[BoxOffices.title],
        genre = row[BoxOffices.genre],
        poster = row[BoxOffices.poster],
    )

    private fun resultRowToSingleBoxOffice(row: ResultRow) = SingleBoxOfficeDAO(
        performanceId = row[BoxOffices.performanceId],
        title = row[BoxOffices.title],
        poster = row[BoxOffices.poster]
    )

    override suspend fun top10BoxOffices(): List<BoxOfficeDAO> = dbQuery {
        BoxOffices.selectAll().limit(10).orderBy(BoxOffices.ranking).map(::resultRowToBoxOffice)
    }

    override suspend fun findBoxOfficeById(id: String): List<SingleBoxOfficeDAO> = dbQuery {
        BoxOffices.slice(BoxOffices.performanceId, BoxOffices.title, BoxOffices.poster)
            .select { BoxOffices.performanceId eq id }
            .map(::resultRowToSingleBoxOffice)
    }
}