package com.jimmy.routes

import com.jimmy.dao.BoxOfficeDAOImpl
import com.jimmy.dao.PerformanceDAOImpl
import com.jimmy.models.PerformanceDAO
import com.jimmy.response.ResultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.performanceRouting() {
    route("/performance") {
        get {
            call.respond(ResultResponse(HttpStatusCode.OK.value, PerformanceDAOImpl().allPerformances()))
        }
    }

    route("/performance") {
        get {
            val genre = call.request.queryParameters["genre"]
            call.respond(
                ResultResponse(
                    HttpStatusCode.OK.value,
                    PerformanceDAOImpl().findPerformanceByGenre(genre.toString())
                )
            )
        }
    }

    post { }

    delete { "{id}" }
}