package com.himanshoe.base.provider.domain

import com.himanshoe.feature.url.domain.CreateShortUrlUseCase

interface DomainProvider {

    fun provideCreateShortUrlUseCase(): CreateShortUrlUseCase
}