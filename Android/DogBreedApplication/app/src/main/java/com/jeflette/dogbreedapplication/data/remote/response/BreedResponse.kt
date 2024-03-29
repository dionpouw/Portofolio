package com.jeflette.dogbreedapplication.data.remote.response

import android.os.Parcelable
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class BreedResponse(

    @Json(name = "Breed")
    val breedResponse: Breed? = null

) : Parcelable

