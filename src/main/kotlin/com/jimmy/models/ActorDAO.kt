package com.jimmy.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

@Serializable
data class ActorDAO(val name: String)

object  Actors: Table() {
    val performanceId = reference("performanceId", Performances.performanceId)
    val name: Column<String> = varchar("name", 50)
}

//class Actor(id: EntityID<String>) : StringEntity(id) {
//    companion object : StringEntityClass<Actor>(Actors)
//    var performanceId by Actors.performanceId
//    var name by Actors.name
//}