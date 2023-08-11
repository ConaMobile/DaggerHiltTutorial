package com.conamobile.daggerhilttutorial.api

import com.conamobile.daggerhilttutorial.mvvm.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("entries")
    suspend fun getListsWithApi(): Response<DataModel>

}