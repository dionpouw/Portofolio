package com.jeflette.mvvmhilt.domain.repository

import okhttp3.MultipartBody
import okhttp3.RequestBody

interface MyRepository {


    suspend fun register(
        name: String,
        email: String,
        password: String
    )

    suspend fun login(
        email: String,
        password: String
    )

    suspend fun uploadStory(
        token: String,
        file: MultipartBody.Part,
        description: RequestBody,
    )

    suspend fun getStories(token: String)

    suspend fun getStoriesWithPageSizeLocation(
        token: String,
        page: Int = 1,
        size: Int = 10,
        location: Int = 1
    )
}