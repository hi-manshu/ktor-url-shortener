package com.himanshoe.util

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.util.pipeline.*

suspend inline fun <reified T : Any> PipelineContext<*, ApplicationCall>.getBodyContent(): T {
    return call.receive()
}