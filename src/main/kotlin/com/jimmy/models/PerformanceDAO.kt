package com.jimmy.models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class PerformanceDAO(val performanceId: String, val title: String, val actor: List<ActorDAO>, val poster: String, val genre: String)

object Performances : Table() {
    val performanceId = varchar("performanceId", 20)
    val title = varchar("title", 50)
    var poster = varchar("poster", 255)
    var genre = varchar("genre", 4)
    override val primaryKey = PrimaryKey(performanceId)
}