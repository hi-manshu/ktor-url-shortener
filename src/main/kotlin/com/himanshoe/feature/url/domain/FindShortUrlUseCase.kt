package com.himanshoe.feature.url.domain

import com.himanshoe.feature.url.repository.UrlRepository

class FindShortUrlUseCase(private val urlRepository: UrlRepository) {
    /** Executes this use case with given input. */
    suspend fun invoke(input: String): String? {
        return urlRepository.findOriginalUrl(input)
    }
}
