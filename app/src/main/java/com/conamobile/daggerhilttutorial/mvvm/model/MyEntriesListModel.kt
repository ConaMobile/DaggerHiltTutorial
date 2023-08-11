package com.conamobile.daggerhilttutorial.mvvm.model


import androidx.annotation.Keep

@Keep
data class MyEntriesListModel(
    val API: String,
    val Auth: String,
    val Category: String,
    val Cors: String,
    val Description: String,
    val HTTPS: Boolean,
    val Link: String,
)