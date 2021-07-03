package com.himanshoe.di

import com.himanshoe.base.provider.service.ServiceProvider
import com.himanshoe.base.provider.service.ServiceProviderImpl
import com.himanshoe.feature.url.service.UrlService

object ServiceLocator {

    fun provideUrlService(): UrlService {
        return provideServiceProvider().provideUrlService()
    }

    fun provideServiceProvider(): ServiceProvider {
        return ServiceProviderImpl(DatabaseLocator)
    }
}