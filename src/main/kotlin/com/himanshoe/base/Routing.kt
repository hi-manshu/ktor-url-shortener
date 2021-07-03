package com.himanshoe.base

import com.himanshoe.di.DomainLocator
import com.himanshoe.feature.url.routing.urlRoutes
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.routing.*

val domainLocator = DomainLocator

fun Application.configureRouting() {
    install(Locations)
    routing {
        urlRoutes(domainLocator)
    }
}
