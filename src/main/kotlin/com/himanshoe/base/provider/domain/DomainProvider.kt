package com.himanshoe.base.provider.domain

import com.himanshoe.feature.url.domain.CreateShortUrlUseCase
import com.himanshoe.feature.url.domain.FindShortUrlUseCase

interface DomainProvider {

    fun provideCreateShortUrlUseCase(): CreateShortUrlUseCase

    fun provideFindShortUrlUseCase(): FindShortUrlUseCase
}
