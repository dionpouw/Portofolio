package com.jeflette.affirmation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeflette.affirmation.data.BaseRepository
import com.jeflette.affirmation.data.remote.response.NewResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: BaseRepository
) : ViewModel() {

    private val _result = MutableLiveData<List<NewResponse>>()
    val result: LiveData<List<NewResponse>> = _result

    fun getAffirmation() {
        viewModelScope.launch {
            val response = repo.getAffirmation()
            _result.postValue(response)
        }
    }

    fun getAllAffirmation() {
        viewModelScope.launch {
            val response = repo.getListAffirmation()
            _result.postValue(response)
        }
    }
}