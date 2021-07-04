package com.himanshoe.base.provider.domain

import com.himanshoe.feature.url.domain.CreateShortUrlUseCase
import com.himanshoe.feature.url.domain.FindShortUrlUseCase
import com.himanshoe.feature.url.domain.FindUrlHitCountUseCase

interface DomainProvider {

    fun provideCreateShortUrlUseCase(): CreateShortUrlUseCase

    fun provideFindShortUrlUseCase(): FindShortUrlUseCase

    fun provideFindUrlHitCountUseCase(): FindUrlHitCountUseCase
}
