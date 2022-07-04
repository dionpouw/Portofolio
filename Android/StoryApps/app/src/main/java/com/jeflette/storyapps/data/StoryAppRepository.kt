package com.jeflette.storyapps.data

import android.content.Context
import com.jeflette.storyapps.data.local.preference.UserPreference
import com.jeflette.storyapps.network.ApiService
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.await

class StoryAppRepository private constructor(
    private val api: ApiService,
    private val preference: UserPreference,
    context: Context
) {
    suspend fun getStories() = api.getStories(preference.getToken().toString())

    suspend fun getStoriesWithPageSizeLocation(pageSize: Int, location: Int) =
        api.getStoriesWithPageSizeLocation(preference.getToken().toString(), pageSize, location)

    suspend fun logout() = preference.logout()

    suspend fun login(email: String, password: String) {
        val token = api.login(email, password).await().loginResult?.token
        token?.let { preference.login(it) }
    }

    fun uploadStory(file: MultipartBody.Part, description: RequestBody) =
        api.uploadStory(preference.getToken().toString(), file, description)


    companion object {
        @Volatile
        private var instance: StoryAppRepository? = null
        fun getInstance(
            apiService: ApiService,
            preference: UserPreference,
            context: Context
        ): StoryAppRepository = instance ?: synchronized(this) {
            instance ?: StoryAppRepository(apiService, preference, context).also { instance = it }
        }
    }
}