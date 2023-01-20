package com.jimmy.models

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ExhibitionDAO(
    val performanceId: String,
    val ranking: Int,
    val title: String,
    val genre: String,
    val poster: String,
    val story: String,
    val area: String,
    val place: String,
    val startDate: String,
    val endDate: String,
    val link: String
)

object Exhibitions: Table() {
    val performanceId = varchar("performanceId", 20)
    val title = varchar("title", 100)
    var ranking = integer("ranking")
    var genre = varchar("genre", 10)
    var poster = varchar("poster", 255)
    var story = text("story")
    var area = varchar("area", 20)
    var place = varchar("place", 255)
    var startDate = varchar("start_date", 10)
    var endDate = varchar("end_date", 10)
    var link = varchar("link", 255)
    override val primaryKey = PrimaryKey(performanceId)
}