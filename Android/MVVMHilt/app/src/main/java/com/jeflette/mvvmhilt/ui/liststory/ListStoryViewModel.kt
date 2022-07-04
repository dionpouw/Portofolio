package com.jeflette.mvvmhilt.ui.liststory

import androidx.lifecycle.ViewModel
import com.jeflette.mvvmhilt.data.repository.StoryAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListStoryViewModel @Inject constructor(private val repository: StoryAppRepository) :
    ViewModel() {

    suspend fun getStories(token: String) = repository.getStory(token)

    suspend fun getStoriesWithPageSizeLocation(token: String, pageSize: Int, location: Int) =
        repository.getStoriesWithPageSizeLocation(token, pageSize, location)
}