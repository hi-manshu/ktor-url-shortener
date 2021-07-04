package com.himanshoe.feature.url.service

import com.himanshoe.NotFoundException
import com.himanshoe.feature.url.entity.UrlEntity
import com.himanshoe.util.generateRandomUrl
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.eq
import java.lang.Exception
import java.util.*

class UrlServiceImpl(private val urlCollection: CoroutineCollection<UrlEntity>) : UrlService {

    override suspend fun createShortUrl(url: String): String? {
        val shortUrl = generateRandomUrl()
        val request = UrlEntity(
            originalUrl = url,
            shortUrl = shortUrl,
            createdAt = Date().toInstant().toString(),
        )
        val isShortUrlCreated = urlCollection.insertOne(request).wasAcknowledged()
        return if (isShortUrlCreated) {
            shortUrl
        } else {
            null
        }
    }

    override suspend fun findShortUrl(url: String): String? {
        val urlEntity = urlCollection.findOne(UrlEntity::originalUrl eq url)
        return urlEntity?.shortUrl
    }

    override suspend fun findOriginalUrl(url: String): String? {
        val urlEntity = urlCollection.findOne(UrlEntity::shortUrl eq url)
        updateCount(urlEntity)
        return urlEntity?.originalUrl
    }

    override suspend fun checkIfUrlIsPresent(url: String): Boolean {
        return findShortUrl(url) != null
    }

    override suspend fun getTotalCount(url: String): Int? {
        val urlEntity = urlCollection.findOne(UrlEntity::shortUrl eq url)
        return urlEntity?.urlHitCount
    }

    private suspend fun updateCount(urlEntity: UrlEntity?) {
        urlEntity?.let { entity ->
            val count = entity.urlHitCount.plus(1)
            val newEntity = entity.copy(urlHitCount = count)
            urlCollection.updateOne(UrlEntity::shortUrl eq entity.shortUrl, newEntity)
        }
    }
}
