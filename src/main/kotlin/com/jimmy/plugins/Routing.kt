package com.jimmy.plugins

import com.jimmy.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*


fun Application.configureRouting() {

    routing {
        homeRouting()
        genreRouting()
        performanceRouting()
        boxOfficeRouting()
        facilityRouting()
    }
}
