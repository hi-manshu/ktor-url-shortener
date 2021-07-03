package com.himanshoe.feature.url.routing

import com.himanshoe.base.provider.exception.ExceptionProvider
import com.himanshoe.di.DomainLocator
import com.himanshoe.feature.url.request.UrlRequest
import com.himanshoe.util.getBodyContent
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.locations.post
import io.ktor.response.*
import io.ktor.routing.*

fun Application.urlRoutes(domainLocator: DomainLocator, exceptionProvider: ExceptionProvider) {

    routing {
        post<UrlLocation> {
            val urlRequest = getBodyContent<UrlRequest>()
            val response = domainLocator.provideDomainProvider().provideCreateShortUrlUseCase().invoke(urlRequest.url)
            call.respond(response)
        }

        get<ShortUrlLocation> { request ->
            val shortUrl = request.url
            val response = domainLocator.provideDomainProvider().provideFindShortUrlUseCase().invoke(shortUrl)
            when {
                response != null -> call.respondRedirect(response)
                else -> call.respond(
                    HttpStatusCode.NotFound,
                    exceptionProvider.respondWithNotFoundException("Url not found!")
                )
            }
        }
    }
}