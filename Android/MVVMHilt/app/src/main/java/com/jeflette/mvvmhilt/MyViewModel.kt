package com.jeflette.mvvmhilt

import androidx.lifecycle.ViewModel
import com.jeflette.mvvmhilt.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: MyRepository
):ViewModel() {
}