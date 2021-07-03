package com.himanshoe.feature.url.routing

import com.himanshoe.feature.url.entity.UrlEntity
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
@Location(UrlEntity.URL)
class UrlLocation

@KtorExperimentalLocationsAPI
@Location(UrlEntity.FORM_URL)
class FormUrlLocation

@KtorExperimentalLocationsAPI
@Location(UrlEntity.SHORT_URL)
data class ShortUrlLocation(val url: String)
