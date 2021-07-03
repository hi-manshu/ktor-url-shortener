package com.himanshoe.feature.url.service

import com.himanshoe.util.BaseResponse

interface UrlService {

    suspend fun createShortUrl(url: String): String?

    suspend fun findShortUrl(url: String): String?

    suspend fun findOriginalUrl(url: String): String?

    suspend fun checkIfUrlIsPresent(url: String): Boolean
}