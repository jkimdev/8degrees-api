package com.jimmy.routes

import com.jimmy.dao.BoxOfficeDAOFacadeImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.boxOfficeRouting() {

    route("/boxoffice") {
        get {
            call.respond(BoxOfficeDAOFacadeImpl().allBoxOffices())
        }
    }
}