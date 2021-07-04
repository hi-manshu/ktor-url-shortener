package com.himanshoe.feature.url.routing

import com.himanshoe.base.provider.exception.ExceptionProvider
import com.himanshoe.di.DomainLocator
import com.himanshoe.feature.url.request.UrlRequest
import com.himanshoe.util.getBodyContent
import com.himanshoe.util.isValid
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

            if (isValid(urlRequest.url)) {
                val response =
                    domainLocator.provideDomainProvider().provideCreateShortUrlUseCase().invoke(urlRequest.url)
                call.respond(response)
            } else {
                call.respond(
                    HttpStatusCode.BadRequest,
                    exceptionProvider.respondWithGenericException("Url is not valid!")
                )
            }
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
        get<UrlCount> { request ->
            val shortUrl = request.url
            val response = domainLocator.provideDomainProvider().provideFindUrlHitCountUseCase().invoke(shortUrl)
            call.respond(response)
        }
    }
}
