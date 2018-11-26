package com.tresor.app

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

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