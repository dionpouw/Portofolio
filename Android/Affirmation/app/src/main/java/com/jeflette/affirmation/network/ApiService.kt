package com.jeflette.affirmation.network

import com.jeflette.affirmation.data.remote.response.NewResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/affirmation")
    suspend fun getAffirmation(): List<NewResponse>

    @GET("/affirmation/index")
    suspend fun getListAffirmation(): List<NewResponse>
}