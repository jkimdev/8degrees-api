package com.jimmy.routes

import com.jimmy.dao.GenreDAOImpl
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.genreRouting() {
    route("/categories") {
        get { call.respond(ResultResponse(HttpStatusCode.OK.value, GenreDAOImpl().allGenres())) }
    }
}