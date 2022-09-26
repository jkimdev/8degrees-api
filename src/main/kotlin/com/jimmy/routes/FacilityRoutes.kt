package com.jimmy.routes

import com.jimmy.dao.FacilityDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.facilityRouting() {
    route("performance/near") {
        get {
            val date = call.request.queryParameters["date"]
            val latitude = call.request.queryParameters["latitude"]
            val longitude = call.request.queryParameters["longitude"]
            if (longitude != null && latitude != null) {
                    call.respond(
                        ResultResponse(
                            HttpStatusCode.OK.value,
                            FacilityDAOImpl().findNearPerformance(date.toString(), latitude.toDouble(), longitude.toDouble())
                        ))
            }
        }
    }
}