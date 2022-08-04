package com.jeflette.dogbreedapplication.data.local.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "width")
    val width: Int? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "height")
    val height: Int? = null
) : Parcelable