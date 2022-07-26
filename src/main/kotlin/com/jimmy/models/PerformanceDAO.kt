package com.jimmy.models

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class PerformanceDAO(val performance_id: String, val title: String)

object Performances : Table() {
    val performance_id = varchar("performance_id", 20)
    val title = varchar("title", 50)
    override val primaryKey = PrimaryKey(performance_id)
}