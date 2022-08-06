package com.jimmy.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@Serializable
data class ActorDAO(val name: String)
object Actors : Table() {
    val performanceId = reference("performanceId", Performances.performanceId)
    val name: Column<String> = varchar("name", 50)
}