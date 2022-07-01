package com.jeflette.affirmation.network

import com.jeflette.affirmation.data.remote.response.NewResponse
import retrofit2.Call
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getAffirmation():List<NewResponse> {
        return apiService.getAffirmation()
    }

    override suspend fun getListAffirmation():List<NewResponse>{
        return apiService.getListAffirmation()
    }
}


