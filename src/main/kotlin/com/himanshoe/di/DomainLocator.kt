package com.himanshoe.di

import com.himanshoe.base.provider.domain.DomainProvider
import com.himanshoe.base.provider.domain.DomainProviderImpl

object DomainLocator {

    fun provideDomainProvider(): DomainProvider {
        return DomainProviderImpl(
            RepositoryLocator.provideRepositoryProvider()
        )
    }
}