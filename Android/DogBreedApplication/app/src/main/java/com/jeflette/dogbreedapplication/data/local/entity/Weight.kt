package com.jeflette.dogbreedapplication.data.local.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weight(

    @Json(name = "metric")
    val metric: String? = null,

    @Json(name = "imperial")
    val imperial: String? = null
) : Parcelable