package com.himanshoe.feature.url.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class UrlEntity(
    @BsonId
    val userId: String = ObjectId().toString(),
    val originalUrl: String,
    val shortUrl: String,
    val createdAt: String,
    val urlHitCount: Int = 0
) {
    companion object {
        const val URL = "/v1/url"
        const val URL_COUNT = "/v1/{url}/count"
        const val FORM_URL = "/v1/form"
        const val SHORT_URL = "/{url}"
    }
}
