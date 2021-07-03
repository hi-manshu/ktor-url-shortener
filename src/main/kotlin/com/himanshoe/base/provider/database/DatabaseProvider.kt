package com.himanshoe.base.provider.database

import com.himanshoe.feature.url.entity.UrlEntity

import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

interface DatabaseProvider {

    val initializeName: String

    val mongoClient: CoroutineClient

    val database: CoroutineDatabase

    val urlCollection: CoroutineCollection<UrlEntity>
}