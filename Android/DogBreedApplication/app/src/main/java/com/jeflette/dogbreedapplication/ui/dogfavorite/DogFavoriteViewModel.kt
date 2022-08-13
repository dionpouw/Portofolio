package com.jeflette.dogbreedapplication.ui.dogfavorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeflette.dogbreedapplication.data.DogsRepository
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogFavoriteViewModel @Inject constructor(
    private val repository: DogsRepository
) : ViewModel() {

    private var dogFavoriteList = MutableLiveData<List<Breed>>()
    val dogFavorite get() = dogFavoriteList

    fun getFavoriteDogs() {
        viewModelScope.launch {
            dogFavoriteList.value = repository.getBreedFavorite()
        }
    }
}