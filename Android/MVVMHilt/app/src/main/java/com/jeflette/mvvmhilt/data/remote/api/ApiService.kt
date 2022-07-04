package com.jeflette.mvvmhilt.data.remote.api

import com.jeflette.mvvmhilt.data.remote.response.CommonResponse
import com.jeflette.mvvmhilt.data.remote.response.GetAllStoryResponse
import com.jeflette.mvvmhilt.data.remote.response.LoginResponse
import com.jeflette.mvvmhilt.util.Const
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST(Const.REGISTER_URL)
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<CommonResponse>

    @FormUrlEncoded
    @POST(Const.LOGIN_URL)
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @Multipart
    @POST(Const.POSTS_URL)
    suspend fun uploadStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<CommonResponse>

    @GET(Const.POSTS_URL)
    suspend fun getStories(@Header("Authorization") token: String): Call<GetAllStoryResponse>

    @GET(Const.POSTS_URL)
    suspend fun getStoriesWithPageSizeLocation(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1,
        @Query("page") size: Int = 10,
        @Query("location") location: Int = 1
    ): Call<GetAllStoryResponse>
}