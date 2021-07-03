package com.himanshoe.feature.url.routing

import com.himanshoe.di.DomainLocator
import com.himanshoe.feature.url.request.UrlRequest
import com.himanshoe.util.getBodyContent
import io.ktor.application.*
import io.ktor.locations.post
import io.ktor.response.*
import io.ktor.routing.*

fun Application.urlRoutes(domainLocator: DomainLocator) {

    routing {
        post<UrlLocation> {
            val urlRequest = getBodyContent<UrlRequest>()
            val response = domainLocator.provideDomainProvider().provideCreateShortUrlUseCase().invoke(urlRequest.url)
            call.respond(response)
        }
    }
}