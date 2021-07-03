package com.himanshoe.base.provider.repository

import com.himanshoe.feature.url.repository.UrlRepository

interface RepositoryProvider {

    fun provideUrlRepository(): UrlRepository
}
