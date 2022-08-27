package com.jimmy.models

import io.ktor.http.*
import kotlinx.serialization.Contextual
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class BoxOfficeDAO(
    val performanceId: String,
    val ranking: Int,
    val title: String,
    val genre: String,
    val poster: String,
)

@kotlinx.serialization.Serializable
data class SingleBoxOfficeDAO(val performanceId: String, val title: String, val poster: String)


object BoxOffices: Table() {
    val performanceId = varchar("performanceId", 20)
    val title = varchar("title", 50)
    var ranking = integer("ranking")
    var genre = varchar("genre", 10)
    var poster = varchar("poster", 255)
    override val primaryKey = PrimaryKey(performanceId)
}