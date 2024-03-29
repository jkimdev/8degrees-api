package com.jimmy.routes

import com.jimmy.dao.FacilityDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.facilityRouting() {
    route("/api/facility/near") {
        get {
            val latitude = call.request.queryParameters["latitude"]
            val longitude = call.request.queryParameters["longitude"]
            if (longitude != null && latitude != null) {
                    call.respond(
                        ResultResponse(
                            HttpStatusCode.OK.value,
                            FacilityDAOImpl().findNearFacility(latitude.toDouble(), longitude.toDouble())
                        ))
            }
        }
    }
}