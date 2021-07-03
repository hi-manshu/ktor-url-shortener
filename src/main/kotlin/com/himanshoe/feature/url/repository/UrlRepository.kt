package com.himanshoe.feature.url.repository

import com.himanshoe.util.BaseResponse

interface UrlRepository {

    suspend fun createShortUrl(originUrl: String): BaseResponse<Any>

    suspend fun findOriginalUrl(shortUrl: String): String?
}