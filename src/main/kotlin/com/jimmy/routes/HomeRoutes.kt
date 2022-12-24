package com.jimmy.routes

import com.jimmy.dao.GenreDAOImpl
import com.jimmy.dao.HomeDAOImpl
import com.jimmy.response.HomeResultResponse
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.homeRouting() {
    route("/api/home") {
        get { call.respond(HomeResultResponse(HttpStatusCode.OK.value, HomeDAOImpl().getHome())) }
    }
}