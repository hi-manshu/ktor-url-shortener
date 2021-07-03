package com.himanshoe

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<NotFoundException> { cause ->
            call.respond(ExceptionResponse(HttpStatusCode.NotFound, cause.message.toString()))
        }
        exception<SomethingWentWrongException> { cause ->
            call.respond(ExceptionResponse(HttpStatusCode.InternalServerError, cause.message.toString()))
        }

    }
}

class NotFoundException(message: String?) : RuntimeException(message)

class SomethingWentWrongException(message: String = "Something went wrong!") : RuntimeException(message)

data class ExceptionResponse(val code: HttpStatusCode, val message: String? = null)
