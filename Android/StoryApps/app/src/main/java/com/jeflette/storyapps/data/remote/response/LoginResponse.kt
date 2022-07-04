package com.jeflette.storyapps.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(

    @field:SerializedName("loginResult")
    @Expose
    val loginResult: LoginResult? = null,

    @field:SerializedName("response")
    val response: Response? = null,

    ) : Parcelable

@Parcelize
data class LoginResult(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("userId")
    val userId: String? = null,

    @field:SerializedName("token")
    val token: String? = null
) : Parcelable