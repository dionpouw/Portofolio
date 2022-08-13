package com.jeflette.dogbreedapplication.ui.dogdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeflette.dogbreedapplication.data.DogsRepository
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogDetailViewModel @Inject constructor(private val repository: DogsRepository) : ViewModel() {

    fun setDogFavorite(breed: Breed, isFavorite: Boolean) {
        viewModelScope.launch {
            repository.setBreedFavorite(breed, isFavorite)
        }
    }
}