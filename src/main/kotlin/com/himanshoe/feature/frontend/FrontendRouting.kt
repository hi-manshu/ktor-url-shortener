package com.himanshoe.feature.frontend

import com.himanshoe.base.provider.exception.ExceptionProvider
import com.himanshoe.di.DomainLocator
import com.himanshoe.feature.frontend.views.landingPage
import com.himanshoe.feature.frontend.views.responsePage
import io.ktor.application.*
import io.ktor.routing.*

fun Application.frontendRouting(domainLocator: DomainLocator, provideExceptionProvider: ExceptionProvider) {

    routing {
        landingPage()
        responsePage(domainLocator, provideExceptionProvider)
    }
}
