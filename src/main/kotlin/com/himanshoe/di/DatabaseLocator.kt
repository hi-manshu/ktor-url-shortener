package com.himanshoe.di

import com.himanshoe.base.provider.database.DatabaseProvider
import com.himanshoe.base.provider.database.DatabaseProviderImpl

object DatabaseLocator {

    private fun provideClientName(): String {
        return "ktor-url-shortner"
    }

    fun provideDatabaseProvider(): DatabaseProvider {
        return DatabaseProviderImpl(provideClientName())
    }
}
