package com.himanshoe.feature.url.repository

import com.himanshoe.feature.url.service.UrlService
import com.himanshoe.util.BaseResponse
import com.himanshoe.util.SuccessResponse
import io.ktor.http.*

class UrlRepositoryImpl(private val urlService: UrlService) : UrlRepository {

    override suspend fun createShortUrl(originUrl: String): BaseResponse<Any> {
        val url = urlService.findUrl(originUrl)
        return if (url != null) {
            SuccessResponse(HttpStatusCode.Found, url)
        } else {
            val newShortUrl = urlService.createShortUrl(originUrl)
            SuccessResponse(HttpStatusCode.Created, newShortUrl)
        }
    }
}