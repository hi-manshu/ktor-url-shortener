package com.himanshoe.feature.url.service

import com.himanshoe.feature.url.entity.UrlEntity
import com.himanshoe.util.generateRandomUrl
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.eq
import java.util.*

class UrlServiceImpl(private val urlCollection: CoroutineCollection<UrlEntity>) : UrlService {

    override suspend fun createShortUrl(url: String): String? {
        val shortUrl = generateRandomUrl()
        val request = UrlEntity(
            originalUrl = url,
            shortUrl = shortUrl,
            createdAt = Date().toInstant().toString()
        )
        val isShortUrlCreated = urlCollection.insertOne(request).wasAcknowledged()
        return if (isShortUrlCreated) {
            shortUrl
        } else {
            null
        }
    }

    override suspend fun findUrl(url: String): String? {
        val urlEntity: UrlEntity? = urlCollection.findOne(UrlEntity::originalUrl eq url)
        return urlEntity?.shortUrl
    }

    override suspend fun checkIfUrlIsPresent(url: String): Boolean {
        return findUrl(url) != null
    }
}