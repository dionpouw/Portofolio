package com.jeflette.mvvmhilt.ui.register

import androidx.lifecycle.ViewModel
import com.jeflette.mvvmhilt.data.repository.StoryAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: StoryAppRepository
): ViewModel() {
    fun register(email:String, name:String, password:String) {
        val client = repository.register(email, name, password)

    }
}