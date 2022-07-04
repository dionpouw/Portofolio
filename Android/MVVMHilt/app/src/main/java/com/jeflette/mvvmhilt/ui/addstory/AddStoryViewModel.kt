package com.jeflette.mvvmhilt.ui.addstory

import androidx.lifecycle.ViewModel
import com.jeflette.mvvmhilt.data.repository.StoryAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class AddStoryViewModel @Inject constructor(private val repository: StoryAppRepository) :
    ViewModel() {
    fun addStory(token: String, file: MultipartBody.Part, description: RequestBody) =
        repository.addStory(token, file, description)
}