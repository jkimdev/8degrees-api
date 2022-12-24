package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import java.time.LocalDate

class HomeDAOImpl : HomeDAOFacade {
    private fun resultRowToGetHome(row: ResultRow) = HomeDAO(genres = Genres.selectAll().map {
        GenreDAO(
            id = it[Genres.id], code = it[Genres.code], value = it[Genres.value], image = it[Genres.image]
        )
    }, boxOffices = BoxOffices.selectAll().map {
        BoxOfficeDAO(
            performanceId = it[BoxOffices.performanceId],
            ranking = it[BoxOffices.ranking],
            title = it[BoxOffices.title],
            genre = it[BoxOffices.genre],
            poster = it[BoxOffices.poster]
        )
    }, upcomingPerformances = Performances.slice(
        Performances.performanceId,
        Performances.title,
        Performances.poster,
        Performances.genre,
        Performances.startDate,
        Performances.endDate,
        Performances.rating
    ).selectAll().map {
        SimplePerformanceDAO(
            performanceId = it[Performances.performanceId],
            title = it[Performances.title],
            poster = it[Performances.poster],
            genre = it[Performances.genre],
            startDate = it[Performances.startDate],
            endDate = it[Performances.endDate],
            rating = it[Performances.rating],
        )
    })

    private fun resultRowToGenre(row: ResultRow) = GenreDAO(
        id = row[Genres.id], code = row[Genres.code], value = row[Genres.value], image = row[Genres.image]
    )

    private fun resultRowToBoxOffice(row: ResultRow) = BoxOfficeDAO(
        performanceId = row[BoxOffices.performanceId],
        ranking = row[BoxOffices.ranking],
        title = row[BoxOffices.title],
        genre = row[BoxOffices.genre],
        poster = row[BoxOffices.poster],
    )

    private fun resultRowToPerformance(row: ResultRow) = SimplePerformanceDAO(
        performanceId = row[Performances.performanceId],
        title = row[Performances.title],
        poster = row[Performances.poster],
        genre = row[Performances.genre],
        rating = row[Performances.rating],
        startDate = row[Performances.startDate],
        endDate = row[Performances.endDate]
    )

    override suspend fun getHome(): HomeDAO = dbQuery {
        HomeDAO(
            genres = Genres.selectAll().map(::resultRowToGenre),
            boxOffices = BoxOffices.selectAll().limit(10).orderBy(BoxOffices.ranking).map(::resultRowToBoxOffice),
            upcomingPerformances = Performances
                .select {
                    (Performances.startDate greaterEq LocalDate.now().toString())
                }
                .orderBy(Performances.startDate)
                .limit(10)
                .map(::resultRowToPerformance)
        )
    }
}
