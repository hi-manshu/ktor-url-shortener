package com.himanshoe.feature.url.service

interface UrlService {

    suspend fun createShortUrl(url: String): String?

    suspend fun findUrl(url: String): String?

    suspend fun checkIfUrlIsPresent(url: String): Boolean
}