package com.himanshoe.util

import java.net.URL


fun generateRandomUrl(length: Int = 6): String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}

fun isValid(url: String?): Boolean {
    return try {
        URL(url).toURI()
        true
    }
    catch (e: Exception) {
        false
    }
}