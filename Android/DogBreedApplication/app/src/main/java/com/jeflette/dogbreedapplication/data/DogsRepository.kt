package com.jeflette.dogbreedapplication.data

import com.jeflette.dogbreedapplication.data.local.entity.Breed
import com.jeflette.dogbreedapplication.data.local.room.DogsDatabase
import com.jeflette.dogbreedapplication.network.ApiService
import com.jeflette.dogbreedapplication.util.networkBoundResource
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val apiService: ApiService,
    db: DogsDatabase
) {

    private val breedDao = db.breedDao()

    @Suppress("UNCHECKED_CAST")
    fun getBreeds() = networkBoundResource(
        query = { breedDao.getAllBreeds() },
        fetch = { apiService.getBreedList() },
        saveFetchResult = {
            breedDao.insertBreed(it)
        }
    )

    suspend fun getBreedFavorite() = breedDao.getBreedFavorite()

    suspend fun setBreedFavorite(breed: Breed, isFavorite: Boolean) {
        breed.isFavorite = isFavorite
        breedDao.updateBreed(breed)
    }

    suspend fun searchBreed(breed: String) = apiService.getSearchBreed(breed)

}