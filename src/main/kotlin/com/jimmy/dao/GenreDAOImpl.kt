package com.jimmy.dao

import com.jimmy.models.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class GenreDAOImpl : GenreDAOFacade {
    private fun resultRowToGenre(row: ResultRow) = GenreDAO(
        id = row[Genres.id],
        code = row[Genres.code],
        value = row[Genres.value],
        image = row[Genres.image]
    )

    override suspend fun allGenres(): List<GenreDAO> = dbQuery {
        Genres.selectAll().map(::resultRowToGenre)
    }
}