package com.jimmy.routes

import com.jimmy.dao.PerformanceDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.performanceRouting() {
    route("/performance") {
        get {
            call.respond(ResultResponse(HttpStatusCode.OK.value, PerformanceDAOImpl().allPerformances()))
        }
    }

    post { }

    delete { "{id}" }
}