package com.himanshoe.feature.frontend

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.frontendRouting() {
    routing {
        get("/") {
            val name = "Ktor"
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
                            classes = "secondary",
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