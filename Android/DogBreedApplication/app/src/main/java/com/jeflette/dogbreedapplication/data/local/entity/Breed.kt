package com.jeflette.dogbreedapplication.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jeflette.dogbreedapplication.data.remote.response.SearchResponse
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

    @Json(name = "origin")
    val origin: String? = null,

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

    var isFavorite: Boolean? = false

) : Parcelable {

    object ModelMapper {
        fun from(listSearchResponse: List<SearchResponse>): List<Breed> {
            return listSearchResponse.map {
                Breed(
                    lifeSpan = it.lifeSpan,
                    breedGroup = it.breedGroup,
                    temperament = it.temperament,
                    name = it.name,
                    weight = it.weight,
                    bredFor = it.bredFor,
                    id = it.id,
                    referenceImageId = it.referenceImageId,
                    height = it.height,
                    isFavorite = false
                )
            }
        }
    }
}
