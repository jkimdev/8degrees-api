package com.jimmy.routes

import com.jimmy.dao.PerformanceDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
fun Route.performanceRouting() {
    route("/api/performance/{pid}") {
        get {
            val pid = call.parameters["pid"]
            call.respond(
                ResultResponse(
                    HttpStatusCode.OK.value,
                    PerformanceDAOImpl().findSinglePerformance(pid.toString())
                )
            )
        }
    }

    route("/api/performance/genre") {
        get {
            val genre = call.request.queryParameters["genre"]
            val offset = call.request.queryParameters["offset"]?.toInt()
            val limit = call.request.queryParameters["limit"]?.toInt()
            if (offset != null && limit != null) {
                call.respond(
                    ResultResponse(
                        HttpStatusCode.OK.value,
                        PerformanceDAOImpl().findPerformanceByGenre(
                            genre.toString(),
                            offset,
                            limit
                        )
                    )
                )
            }
        }
    }

    route("/api/performance/upComing") {
        get {
            val offset = call.request.queryParameters["offset"]?.toInt()
            val limit = call.request.queryParameters["limit"]?.toInt()
            if (offset != null && limit != null) {
                call.respond(
                    ResultResponse(
                        HttpStatusCode.OK.value,
                        PerformanceDAOImpl().findUpComingPerformance(
                            offset,
                            limit
                        )
                    )
                )
            }
        }
    }

    route("/api/performance/facility") {
        get {
            val facilityId = call.request.queryParameters["facilityId"]
            val offset = call.request.queryParameters["offset"]?.toInt()
            val limit = call.request.queryParameters["limit"]?.toInt()
            if (offset != null && limit != null) {
                call.respond(
                    ResultResponse(
                        HttpStatusCode.OK.value,
                        PerformanceDAOImpl().findPerformanceByFacility(
                            facilityId.toString(),
                            offset,
                            limit
                        )
                    )
                )
            }
        }
    }

    post { }

    delete { "{id}" }
}