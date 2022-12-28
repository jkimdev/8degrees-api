package com.jimmy.routes

import com.jimmy.dao.BoxOfficeDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.boxOfficeRouting() {

    route("/api/top10BoxOffice") {
        get {
            call.respond(ResultResponse(HttpStatusCode.OK.value, BoxOfficeDAOImpl().top10BoxOffices()))
        }
    }
//    route("/boxOffice/{id}") {
//        get {
//            val id = call.parameters["id"]
//            call.respond(ResultResponse(HttpStatusCode.OK.value, BoxOfficeDAOImpl().findBoxOfficeById(id.toString())))
//        }
//    }
}