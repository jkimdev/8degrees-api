package com.jimmy.routes

import com.jimmy.dao.PerformanceDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.performanceRouting() {
    route("/performance/{pid}") {
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

    route("/performance/genre") {
        get {
            val genre = call.request.queryParameters["genre"]
            val startIdx = call.request.queryParameters["startIdx"]
            val endIdx = call.request.queryParameters["endIdx"]
            call.respond(
                ResultResponse(
                    HttpStatusCode.OK.value,
                    PerformanceDAOImpl().findPerformanceByGenre(
                        genre.toString(),
                        startIdx.toString(),
                        endIdx.toString()
                    )
                )
            )
        }
    }

    route("/performance/upComing") {
        get {
            val date = call.request.queryParameters["date"]
            val startIdx = call.request.queryParameters["startIdx"]
            val endIdx = call.request.queryParameters["endIdx"]
            call.respond(
                ResultResponse(
                    HttpStatusCode.OK.value,
                    PerformanceDAOImpl().findUpComingPerformance(
                        date.toString(),
                        startIdx.toString(),
                        endIdx.toString()
                    )
                )
            )
        }
    }

    route("performance/near") {
        get {
            val date = call.request.queryParameters["date"]
            val latitude = call.request.queryParameters["latitude"]
            val longitude = call.request.queryParameters["longitude"]
            call.respond(
                ResultResponse(
                    HttpStatusCode.OK.value,
                    PerformanceDAOImpl().findNearPerformance(
                        date.toString(),
                        latitude.toString(),
                        longitude.toString())
                )
            )
        }
    }

    post { }

    delete { "{id}" }
}