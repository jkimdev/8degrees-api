package com.jimmy.models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class PerformanceDAO(val performanceId: String, val title: String, val actor: List<ActorDAO>)

object Performances : Table() {
    val performanceId = varchar("performanceId", 20)
    val title = varchar("title", 50)
    override val primaryKey = PrimaryKey(performanceId)
}