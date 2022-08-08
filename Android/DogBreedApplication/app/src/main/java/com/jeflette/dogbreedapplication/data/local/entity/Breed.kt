package com.jeflette.dogbreedapplication.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "breed_table")
@Parcelize
data class Breed(

    @Json(name = "image")
    val image: Image? = null,

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

    @PrimaryKey
    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "reference_image_id")
    val referenceImageId: String? = null,

    @Json(name = "height")
    val height: Height? = null,

    @Json(name = "history")
    val history: String? = null,

    @Json(name = "country_code")
    val countryCode: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "origin")
    val origin: String? = null,

    var isFavorite: Boolean = false
) : Parcelable
