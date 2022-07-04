package com.jeflette.storyapps.network

import com.jeflette.storyapps.data.remote.response.GetAllStoryResponse
import com.jeflette.storyapps.data.remote.response.LoginResponse
import com.jeflette.storyapps.data.remote.response.Response
import com.jeflette.storyapps.utils.Const
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
    ): Call<Response>

    @FormUrlEncoded
    @POST(Const.LOGIN_URL)
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @Multipart
    @POST(Const.POSTS_URL)
    fun uploadStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): Call<Response>

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