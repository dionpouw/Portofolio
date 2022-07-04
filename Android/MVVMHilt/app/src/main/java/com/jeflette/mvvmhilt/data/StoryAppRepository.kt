package com.jeflette.mvvmhilt.data

import android.content.Context
import com.jeflette.mvvmhilt.data.local.preferences.UserDataStore
import com.jeflette.mvvmhilt.data.remote.api.ApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class StoryAppRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDataStore: UserDataStore,
    private val context: Context
) {

    suspend fun login(username: String, password: String) {
        apiService.login(username, password)
    }

    suspend fun register(email: String, name: String, password: String) {
        apiService.register(email, name, password)
    }

    suspend fun logout() {
        userDataStore.logout(context)
    }

    suspend fun saveToken(token: String) = userDataStore.login(token, context)

    suspend fun addStory(token: String, file: MultipartBody.Part, description: RequestBody) {
        apiService.uploadStory(token, file, description)
    }

    suspend fun getStory(token: String) {
        apiService.getStories(token)
    }

    suspend fun getStoriesWithPageSizeLocation(token: String, pageSize: Int, location: Int) {
        apiService.getStoriesWithPageSizeLocation(token, pageSize, location)
    }

}