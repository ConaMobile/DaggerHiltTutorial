package com.conamobile.daggerhilttutorial.mvvm.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.conamobile.daggerhilttutorial.mvvm.repo.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository,
) : ViewModel() {
    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch(Dispatchers.IO) {
        repository.loadData().collect {
            if (it.isSuccessful) logcat(it.body().toString())
        }
    }
}

fun logcat(message: String) {
    Log.d("@@@", "logcat: $message")
}