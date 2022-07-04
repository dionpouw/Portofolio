package com.jeflette.mvvmhilt.data.repository

import android.app.Application
import com.jeflette.mvvmhilt.R
import com.jeflette.mvvmhilt.data.remote.api.ApiService
import com.jeflette.mvvmhilt.domain.repository.MyRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Field

class MyRepositoryImpl(
    private val apiService: ApiService,
    private val appContext:Application
) : MyRepository {

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ) {
    }

    override suspend fun login(
        email: String,
        password: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun uploadStory(
        token: String,
        file: MultipartBody.Part,
        description: RequestBody
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getStories(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getStoriesWithPageSizeLocation(
        token: String,
        page: Int,
        size: Int,
        location: Int
    ) {
        TODO("Not yet implemented")
    }
}