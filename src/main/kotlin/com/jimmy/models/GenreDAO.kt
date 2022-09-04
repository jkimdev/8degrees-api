package com.jimmy.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class GenreDAO(val code: String, val value: String)

object Genres: Table() {
    val id = integer("id")
    val code = varchar("code", 4)
    var value = varchar("value", 10)
    override val primaryKey = PrimaryKey(id)
}


