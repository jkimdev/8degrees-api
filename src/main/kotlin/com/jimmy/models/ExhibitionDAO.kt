package com.jimmy.models

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ExhibitionDAO(
    val performanceId: String,
    val ranking: Int,
    val title: String,
    val genre: String,
    val poster: String,
)

object Exhibitions: Table() {
    val performanceId = varchar("performanceId", 20)
    val title = varchar("title", 100)
    var ranking = integer("ranking")
    var genre = varchar("genre", 10)
    var poster = varchar("poster", 255)
    override val primaryKey = PrimaryKey(performanceId)
}