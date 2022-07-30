package com.jimmy.routes

import com.jimmy.dao.BoxOfficeDAOFacadeImpl
import com.jimmy.models.BoxOfficeResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.boxOfficeRouting() {

    route("/boxOffice") {
        get {
            call.respond(BoxOfficeResponse(HttpStatusCode.OK.value, BoxOfficeDAOFacadeImpl().allBoxOffices()))
        }
    }
}