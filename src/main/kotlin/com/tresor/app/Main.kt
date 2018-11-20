package com.tresor.app

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, 3001) {
        main()
    }
    server.start(wait = true)
}


fun Application.main() {
    routing {
        get("/") {
            call.respondText("Hello, world!", ContentType.Text.Html)
        }
    }
}