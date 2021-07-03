package com.himanshoe.feature.url.entity

data class UrlEntity(
    val originalUrl: String,
    val shortUrl: String,
    val createdAt: String
){
    companion object{
        const val URL = "/v1/url"
        const val SHORT_URL = "/{url}"
    }
}