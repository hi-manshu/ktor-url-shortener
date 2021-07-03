package com.himanshoe.di

import com.himanshoe.base.provider.exception.ExceptionProvider
import com.himanshoe.base.provider.exception.ExceptionProviderImpl

object ExceptionLocator {

    fun provideExceptionProvider(): ExceptionProvider {
        return ExceptionProviderImpl()
    }
}
