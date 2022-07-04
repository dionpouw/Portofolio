package com.jeflette.storyapps.ui.login

import androidx.lifecycle.ViewModel
import com.jeflette.storyapps.data.StoryAppRepository

class LoginViewModel(private val storyAppRepository: StoryAppRepository) : ViewModel() {

    suspend fun login(email: String, password: String) = storyAppRepository.login(email, password)

}