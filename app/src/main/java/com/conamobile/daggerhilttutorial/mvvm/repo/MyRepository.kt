package com.conamobile.daggerhilttutorial.mvvm.repo

import com.conamobile.daggerhilttutorial.api.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: ApiService,
) {
    fun loadData() = flow { emit(apiService.getListsWithApi()) }
}