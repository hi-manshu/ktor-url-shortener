package com.himanshoe.base.provider.exception

interface ExceptionProvider {

    fun respondWithNotFoundException(message: String?): Exception

    fun respondWithGenericException(message: String?): Exception

    fun respondWithSomethingWentWrongException(): Exception
}
