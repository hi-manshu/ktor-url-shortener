package com.himanshoe.base.provider.repository

import com.himanshoe.di.RepositoryLocator
import com.himanshoe.di.ServiceLocator
import com.himanshoe.feature.url.repository.UrlRepository

class RepositoryProviderImpl(private val serviceLocator: ServiceLocator) : RepositoryProvider {

    override fun provideUrlRepository(): UrlRepository {
        return RepositoryLocator.provideAUrlRepository(serviceLocator.provideUrlService())
    }
}