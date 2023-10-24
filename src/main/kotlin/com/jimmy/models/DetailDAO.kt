package com.jimmy.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@Serializable
data class DetailDAO(
    val styurl: String
)

object Details : Table() {
    val performanceId = reference("performanceId", Performances.performanceId)
    val styurl: Column<String> = varchar("styurl", 255)
}