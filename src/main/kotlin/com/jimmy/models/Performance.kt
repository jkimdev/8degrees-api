package com.jimmy.models

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class Performance(val mt20id: String, val prfnm: String)

object Performances : Table() {
    val mt20id = varchar("id", 128)
    val prfnm = varchar("title", 128)
    override val primaryKey = PrimaryKey(mt20id)
}