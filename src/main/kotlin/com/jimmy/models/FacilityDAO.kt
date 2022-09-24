package com.jimmy.models

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class FacilityDAO(
    val facilityId: String,
    val place: String,
    val telNo: String,
    val url: String,
    val address: String,
    val latitude: String,
    val longitude: String
)

object Facilities: Table() {
    val facilityId = varchar("facilityId", 20)
    val place = varchar("place", 255)
    var telNo = varchar("telNo", 50)
    var url = varchar("url", 255)
    var address = varchar("address", 100)
    var latitude = varchar("latitude", 50)
    var longitude = varchar("longitude", 50)
    override val primaryKey = PrimaryKey(facilityId)
}

