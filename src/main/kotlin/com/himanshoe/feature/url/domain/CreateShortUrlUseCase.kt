package com.himanshoe.feature.url.domain

import com.himanshoe.base.provider.BaseUseCase
import com.himanshoe.feature.url.repository.UrlRepository
import com.himanshoe.util.BaseResponse

class CreateShortUrlUseCase(private val urlRepository: UrlRepository):BaseUseCase<String,Any> {
    /** Executes this use case with given input. */
    override suspend fun invoke(input: String): BaseResponse<Any> {
        return urlRepository.createShortUrl(input)
    }
}