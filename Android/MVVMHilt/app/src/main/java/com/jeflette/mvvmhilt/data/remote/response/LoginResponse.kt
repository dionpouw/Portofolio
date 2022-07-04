package com.jeflette.mvvmhilt.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.jeflette.mvvmhilt.data.local.entity.LoginResult
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(

    @field:SerializedName("loginResult")
    val loginResult: LoginResult? = null,

    @field:SerializedName("commonResponse")
    val response: CommonResponse? = null,

    ) : Parcelable

