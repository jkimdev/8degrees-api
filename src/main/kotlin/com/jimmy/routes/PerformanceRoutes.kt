package com.jimmy.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.performanceRouting() {
    route("/performance") {
        get {
            call.respondText { "test GET request"}
        }

        get("{id}") {}

    }

    post {  }

    delete { "{id}" }
}