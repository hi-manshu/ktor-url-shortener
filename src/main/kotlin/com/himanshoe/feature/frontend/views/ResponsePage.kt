package com.himanshoe.feature.frontend.views

import com.himanshoe.base.provider.exception.ExceptionProvider
import com.himanshoe.di.DomainLocator
import com.himanshoe.feature.url.routing.FormUrlLocation
import com.himanshoe.util.SuccessResponse
import com.himanshoe.util.isValid
import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.locations.post
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.p

fun Application.responsePage(domainLocator: DomainLocator, exceptionProvider: ExceptionProvider) {


    routing {
        post<FormUrlLocation> {
            val params = call.receiveParameters()
            val url = params["url"] ?: ""
            if (isValid(url)) {
                val response =
                    domainLocator.provideDomainProvider().provideCreateShortUrlUseCase().invoke(url)
                call.respondHtml {
                    body {
                        p {
                            if (response is SuccessResponse) {
                                +"Short url is: /${response.data}"
                            }
                        }
                    }
                }
            } else {
                call.respond(
                    HttpStatusCode.BadRequest,
                    exceptionProvider.respondWithGenericException("Url is not valid!")
                )
            }
        }
    }

}