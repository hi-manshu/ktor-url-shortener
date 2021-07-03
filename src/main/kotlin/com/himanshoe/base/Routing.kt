package com.himanshoe.base

import com.himanshoe.di.DomainLocator
import com.himanshoe.di.ExceptionLocator
import com.himanshoe.feature.frontend.frontendRouting
import com.himanshoe.feature.url.routing.urlRoutes
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.routing.*

val domainLocator = DomainLocator
val exceptionLocator = ExceptionLocator

fun Application.configureRouting() {
    install(Locations)
    routing {
        frontendRouting(domainLocator,exceptionLocator.provideExceptionProvider())
        urlRoutes(domainLocator,exceptionLocator.provideExceptionProvider())
    }
}
