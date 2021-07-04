package com.himanshoe.feature.url.domain

import com.himanshoe.MainCoroutineRule
import com.himanshoe.feature.url.repository.UrlRepository
import com.himanshoe.runBlockingTest
import com.himanshoe.util.SuccessResponse
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.ktor.http.*
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CreateShortUrlUseCaseTest{
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val mockUrlRepository = mock<UrlRepository>()

    private lateinit var createShortUrlUseCase: CreateShortUrlUseCase

    @Before
    fun setup() {
        createShortUrlUseCase = CreateShortUrlUseCase(mockUrlRepository)
    }

    @Test
    fun `should create short url successfully`(){
        return coroutineRule.runBlockingTest {
            // Given
            `given a long url should create short url successfully`()
            // When
            val input  = "https://www.google.com"
            // Then
            verify(mockUrlRepository).createShortUrl(input)
        }
    }

    private suspend fun `given a long url should create short url successfully`() {
        val successResponse = SuccessResponse<Any>(HttpStatusCode.Created, true)
        whenever(mockUrlRepository.createShortUrl(any()))
            .thenReturn(successResponse)
    }

}