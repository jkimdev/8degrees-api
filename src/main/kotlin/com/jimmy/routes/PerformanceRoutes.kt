package com.jimmy.routes

import com.jimmy.dao.PerformanceDAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.performanceRouting() {
    route("/performance") {
        get {
            return@get call.respond(PerformanceDAOFacadeImpl().allPerformances())
        }

        get("{id}") {}

    }

    post { }

    delete { "{id}" }
}