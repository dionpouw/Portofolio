package com.jeflette.storyapps.ui.liststory

import androidx.lifecycle.ViewModel
import com.jeflette.storyapps.data.StoryAppRepository

class ListStoryViewModel(private val storyAppRepository: StoryAppRepository) : ViewModel() {

    suspend fun getStories() = storyAppRepository.getStories()

    suspend fun getStoriesWithPageSizeLocation(pageSize: Int, location: Int) =
        storyAppRepository.getStoriesWithPageSizeLocation(pageSize, location)

    suspend fun logout() = storyAppRepository.logout()
}