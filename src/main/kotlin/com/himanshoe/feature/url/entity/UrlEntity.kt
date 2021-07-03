package com.himanshoe.feature.url.entity

data class UrlEntity(
    val originalUrl: String,
    val shortUrl: String,
    val createdAt: String,
    val urlHitCount: Int = 0
) {
    companion object {
        const val URL = "/v1/url"
        const val FORM_URL = "/v1/form"
        const val SHORT_URL = "/{url}"
    }
}