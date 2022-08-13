package com.jeflette.dogbreedapplication.ui.doglist

import androidx.lifecycle.*
import com.jeflette.dogbreedapplication.data.DogsRepository
import com.jeflette.dogbreedapplication.data.remote.response.SearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogListViewModel @Inject constructor(
    private val repository: DogsRepository
) : ViewModel() {

    val dogResponse = repository.getBreeds().asLiveData()

    private val dogsLiveData = MutableLiveData<List<SearchResponse>?>()
    val breeds: LiveData<List<SearchResponse>?> = dogsLiveData

    private val isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = isLoadingLiveData

    fun getBreedSearch(query: String) {
        viewModelScope.launch {
            isLoadingLiveData.value = true
            dogsLiveData.value = repository.searchBreed(query)
            isLoadingLiveData.value = false
        }
    }
}