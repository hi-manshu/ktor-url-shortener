package com.himanshoe.base.provider.exception

import com.himanshoe.NotFoundException
import com.himanshoe.SomethingWentWrongException

class ExceptionProviderImpl : ExceptionProvider {

    override fun respondWithNotFoundException(message: String?): Exception {
        return NotFoundException(message)
    }

    override fun respondWithSomethingWentWrongException(): Exception {
        return SomethingWentWrongException()
    }

}