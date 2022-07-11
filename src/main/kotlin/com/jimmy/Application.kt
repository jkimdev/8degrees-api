package com.jimmy

import com.jimmy.dao.DatabaseFactory
import io.ktor.server.netty.*
import com.jimmy.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
    configureSerialization()
}
//fun main() {
//    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
//        module()
//    }.start(wait = true)
//}
