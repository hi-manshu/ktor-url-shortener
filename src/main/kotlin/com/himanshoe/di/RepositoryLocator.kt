package com.himanshoe.di

import com.himanshoe.base.provider.repository.RepositoryProvider
import com.himanshoe.base.provider.repository.RepositoryProviderImpl
import com.himanshoe.feature.url.repository.UrlRepository
import com.himanshoe.feature.url.repository.UrlRepositoryImpl
import com.himanshoe.feature.url.service.UrlService

object RepositoryLocator {

    fun provideAUrlRepository(urlService: UrlService): UrlRepository {
        return UrlRepositoryImpl(urlService)
    }

    fun provideRepositoryProvider(): RepositoryProvider {
        return RepositoryProviderImpl(ServiceLocator)
    }
}
