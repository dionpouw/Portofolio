package com.jeflette.affirmation.network

import com.jeflette.affirmation.data.remote.response.NewResponse

interface ApiHelper {

    suspend fun getAffirmation(): List<NewResponse>

    suspend fun getListAffirmation(): List<NewResponse>
}