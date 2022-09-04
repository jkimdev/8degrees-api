package com.jimmy.plugins

import com.jimmy.routes.boxOfficeRouting
import com.jimmy.routes.performanceRouting
import com.jimmy.routes.genreRouting
import io.ktor.server.routing.*
import io.ktor.server.application.*


fun Application.configureRouting() {

    routing {
        performanceRouting()
        boxOfficeRouting()
        genreRouting()
    }
}
