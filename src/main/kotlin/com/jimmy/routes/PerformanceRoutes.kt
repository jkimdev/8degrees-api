package com.jimmy.routes

import com.jimmy.dao.PerformanceDAOImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.performanceRouting() {
    route("/performance") {
        get {
            call.respond(PerformanceDAOImpl().allPerformances())
        }

        get("{id}") {}

    }

    post { }

    delete { "{id}" }
}