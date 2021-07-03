package com.himanshoe.base.provider.service

import com.himanshoe.feature.url.service.UrlService

interface ServiceProvider {

    fun provideUrlService(): UrlService
}