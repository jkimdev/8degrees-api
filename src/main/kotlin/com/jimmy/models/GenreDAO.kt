package com.jimmy.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class GenreDAO(val id: Int, val code: String, val value: String, val image: String)

object Genres: Table() {
    val id = integer("id")
    val code = varchar("code", 4)
    var value = varchar("value", 10)
    var image = varchar("image", 50)
    override val primaryKey = PrimaryKey(id)
}


