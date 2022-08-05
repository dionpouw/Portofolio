package com.jeflette.dogbreedapplication.di

import android.app.Application
import androidx.room.Room
import com.jeflette.dogbreedapplication.BuildConfig
import com.jeflette.dogbreedapplication.data.local.room.DogsDatabase
import com.jeflette.dogbreedapplication.network.ApiService
import com.jeflette.dogbreedapplication.util.Constant
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(Constant.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create()).client(okHttpClient).build()

    @Singleton
    @Provides
    fun provideDogsApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): DogsDatabase =
        Room.databaseBuilder(app, DogsDatabase::class.java, "breed.db").build()
}