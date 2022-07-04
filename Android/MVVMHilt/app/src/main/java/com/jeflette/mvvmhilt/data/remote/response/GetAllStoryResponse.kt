package com.jeflette.mvvmhilt.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.jeflette.mvvmhilt.data.local.entity.StoryItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetAllStoryResponse(

    @field:SerializedName("listStory")
    val listStory: List<StoryItem?>? = null,

    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
) : Parcelable
