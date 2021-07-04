package com.himanshoe.base.provider.domain

import com.himanshoe.base.provider.repository.RepositoryProvider
import com.himanshoe.feature.url.domain.CreateShortUrlUseCase
import com.himanshoe.feature.url.domain.FindShortUrlUseCase
import com.himanshoe.feature.url.domain.FindUrlHitCountUseCase

class DomainProviderImpl(private val repositoryProvider: RepositoryProvider) : DomainProvider {

    override fun provideCreateShortUrlUseCase(): CreateShortUrlUseCase {
        return CreateShortUrlUseCase(repositoryProvider.provideUrlRepository())
    }

    override fun provideFindShortUrlUseCase(): FindShortUrlUseCase {
        return FindShortUrlUseCase(repositoryProvider.provideUrlRepository())
    }
    override fun provideFindUrlHitCountUseCase(): FindUrlHitCountUseCase {
        return FindUrlHitCountUseCase(repositoryProvider.provideUrlRepository())
    }
}
