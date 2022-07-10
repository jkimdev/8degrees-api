package com.jimmy

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.jimmy.plugins.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureRouting()
    configureSerialization()
}
//fun main() {
//    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
//        module()
//    }.start(wait = true)
//}
