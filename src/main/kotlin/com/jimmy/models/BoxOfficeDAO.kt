package com.jimmy.models

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class BoxOfficeDAO(val performance_id: String, val title: String, val ranking: Int)

object BoxOffice_tb: Table() {
    val performance_id = varchar("performance_id", 20)
    val title = varchar("title", 50)
    var ranking = integer("ranking")
    override val primaryKey = PrimaryKey(performance_id)
}