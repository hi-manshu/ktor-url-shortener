package com.himanshoe.base.provider.exception

interface ExceptionProvider {

    fun respondWithNotFoundException(message: String?): Exception

    fun respondWithSomethingWentWrongException(): Exception
}