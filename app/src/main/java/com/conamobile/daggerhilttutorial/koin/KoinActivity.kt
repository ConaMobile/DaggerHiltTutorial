package com.conamobile.daggerhilttutorial.koin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import org.koin.android.ext.android.inject

class KoinActivity : ComponentActivity() {

    private val presenter1: Presenter1 by inject()
    private val presenter2: Presenter2 by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = presenter1.name)
                Text(text = presenter2.name)
            }
        }
    }
}