package com.himanshoe.base.provider.service

import com.himanshoe.di.DatabaseLocator
import com.himanshoe.feature.url.service.UrlService
import com.himanshoe.feature.url.service.UrlServiceImpl

class ServiceProviderImpl(private val databaseLocator: DatabaseLocator) : ServiceProvider {

    override fun provideUrlService(): UrlService {
        return UrlServiceImpl(databaseLocator.provideDatabaseProvider().urlCollection)
    }
}
