package com.jeflette.dogbreedapplication.network

import com.jeflette.dogbreedapplication.data.remote.response.BreedResponse
import com.jeflette.dogbreedapplication.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("breeds")
    suspend fun getBreedList(): BreedResponse

    @GET("breeds/search")
    suspend fun getSearchBreed(
        @Query("q") query: String
    ): SearchResponse
}