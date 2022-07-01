package com.jeflette.affirmation.data

import com.jeflette.affirmation.network.ApiHelper
import javax.inject.Inject

class BaseRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getAffirmation() = apiHelper.getAffirmation()

    suspend fun getListAffirmation() = apiHelper.getListAffirmation()
}