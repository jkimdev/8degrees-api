package com.jimmy.models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class PerformanceDAO(
    val performanceId: String,
    val facilityId: String,
    val title: String,
    val actor: List<ActorDAO>,
    val poster: String,
    val genre: String,
    val startDate: String,
    val endDate: String,
    val state: String,
    val runtime: String,
    val rating: String,
    val story: String,
)

@kotlinx.serialization.Serializable
data class SimplePerformanceDAO(
    val performanceId: String,
    val title: String,
    val poster: String,
    val genre: String,
    val runtime: String,
    val rating: String,
    val story: String,
)

object Performances : Table() {
    val performanceId = varchar("performanceId", 20)
    val facilityId = varchar("facilityId", 20)
    val title = varchar("title", 100)
    var poster = varchar("poster", 255)
    var genre = varchar("genre", 4)
    var startDate = varchar("start_date", 10)
    var endDate = varchar("end_date", 10)
    var state = varchar("state", 7)
    var runtime = varchar("runtime", 10)
    var rating = varchar("rating", 30)
    var story = text("story")

    override val primaryKey = PrimaryKey(performanceId)
}