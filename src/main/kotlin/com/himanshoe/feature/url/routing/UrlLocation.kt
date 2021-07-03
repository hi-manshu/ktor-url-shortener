package com.himanshoe.feature.url.routing

import com.himanshoe.feature.url.entity.UrlEntity
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
@Location(UrlEntity.URL)
class UrlLocation

@KtorExperimentalLocationsAPI
@Location(UrlEntity.SHORT_URL)
class ShortUrlLocation

