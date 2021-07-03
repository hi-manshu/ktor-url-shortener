package com.himanshoe.base.provider.domain

import com.himanshoe.base.provider.repository.RepositoryProvider
import com.himanshoe.feature.url.domain.CreateShortUrlUseCase
import com.himanshoe.feature.url.domain.FindShortUrlUseCase

class DomainProviderImpl(private val repositoryProvider: RepositoryProvider) : DomainProvider {

    override fun provideCreateShortUrlUseCase(): CreateShortUrlUseCase {
        return CreateShortUrlUseCase(repositoryProvider.provideUrlRepository())
    }

    override fun provideFindShortUrlUseCase(): FindShortUrlUseCase {
        return FindShortUrlUseCase(repositoryProvider.provideUrlRepository())
    }
}