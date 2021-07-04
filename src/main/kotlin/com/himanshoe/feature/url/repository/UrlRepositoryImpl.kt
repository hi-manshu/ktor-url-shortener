package com.himanshoe.feature.url.repository

import com.himanshoe.base.provider.exception.ExceptionProvider
import com.himanshoe.feature.url.service.UrlService
import com.himanshoe.util.BaseResponse
import com.himanshoe.util.SuccessResponse
import com.himanshoe.util.UnSuccessResponse
import io.ktor.http.*

class UrlRepositoryImpl(
    private val urlService: UrlService,
    private val exceptionProvider: ExceptionProvider
) : UrlRepository {

    override suspend fun createShortUrl(originUrl: String): BaseResponse<Any> {
        val url = urlService.findShortUrl(originUrl)
        return if (url != null) {
            SuccessResponse(HttpStatusCode.Found, url)
        } else {
            val newShortUrl = urlService.createShortUrl(originUrl)
            SuccessResponse(HttpStatusCode.Created, newShortUrl)
        }
    }

    override suspend fun findOriginalUrl(shortUrl: String): String? {
        return urlService.findOriginalUrl(shortUrl)
    }

    override suspend fun getTotalCount(shortUrl: String): BaseResponse<Any> {
        val count = urlService.getTotalCount(shortUrl)
        if (count != null) {
            return SuccessResponse(HttpStatusCode.OK, count)
        } else {
            throw exceptionProvider.respondWithNotFoundException("Url not found!")
        }
    }
}
