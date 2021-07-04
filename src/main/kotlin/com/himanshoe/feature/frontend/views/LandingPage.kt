package com.himanshoe.feature.frontend.views

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.landingPage() {

    routing {
        get("/") {
            call.respondHtml {
                head {
                    title {
                        +"Welcome to URL Shortener"
                    }
                }
                body {
                    form(
                        action = "/v1/form",
                        method = FormMethod.post,
                    ) {
                        label {
                            input(
                                type = InputType.url,
                                name = "url",
                            ) {
                                placeholder = "Enter your url"
                                required = true
                            }
                        }

                        button(
                            classes = "primary",
                            type = ButtonType.submit,
                        ) {
                            +"Shorten"
                        }
                    }
                }
            }
        }
    }
}
