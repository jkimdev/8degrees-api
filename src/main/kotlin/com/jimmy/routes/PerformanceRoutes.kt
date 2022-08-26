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
    }

    route("/performance/{id}") {
        get {
            val id = call.parameters["id"]
            call.respond(PerformanceDAOImpl().findPerformanceById(id.toString()))
        }
    }

    post { }

    delete { "{id}" }
}