package com.jeflette.mvvmhilt.ui.login

import androidx.lifecycle.ViewModel
import com.jeflette.mvvmhilt.data.repository.StoryAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: StoryAppRepository
) : ViewModel() {

    suspend fun login(email: String, password: String) = repository.login(email, password)
    suspend fun saveToken(token:String) = repository.saveToken(token)
}