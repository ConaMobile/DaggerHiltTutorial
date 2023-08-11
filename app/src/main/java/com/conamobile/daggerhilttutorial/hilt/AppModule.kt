package com.conamobile.daggerhilttutorial.hilt

import com.conamobile.daggerhilttutorial.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    @Named("String1")
    fun provideSampleName() = "This is string!"

    @Provides
    @Singleton
    fun provideBaseUrl(): String = "https://api.publicapis.org/"

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).client(
                OkHttpClient().newBuilder().build()
            ).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}