package com.jeflette.dogbreedapplication.data.remote.response

import android.os.Parcelable
import com.jeflette.dogbreedapplication.data.local.entity.Height
import com.jeflette.dogbreedapplication.data.local.entity.Weight
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageSearchResponse(

    @Json(name = "width")
    val width: Int? = null,

    @Json(name = "id")
    val id: String? = null,

    @Json(name = "url")
    val url: String? = null,

    @Json(name = "breeds")
    val breeds: List<BreedsItem?>? = null,

    @Json(name = "height")
    val height: Int? = null
) : Parcelable


@Parcelize
data class BreedsItem(

    @Json(name = "life_span")
    val lifeSpan: String? = null,

    @Json(name = "breed_group")
    val breedGroup: String? = null,

    @Json(name = "temperament")
    val temperament: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "weight")
    val weight: Weight? = null,

    @Json(name = "bred_for")
    val bredFor: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "reference_image_id")
    val referenceImageId: String? = null,

    @Json(name = "height")
    val height: Height? = null
) : Parcelable
