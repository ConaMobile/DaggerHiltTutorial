package com.conamobile.daggerhilttutorial.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import com.conamobile.daggerhilttutorial.koin.KoinActivity
import com.conamobile.daggerhilttutorial.koin.Presenter1
import com.conamobile.daggerhilttutorial.koin.Presenter2
import com.conamobile.daggerhilttutorial.mvvm.vm.MyViewModel
import com.conamobile.daggerhilttutorial.ui.theme.DaggerHiltTutorialTheme
import dagger.hilt.android.AndroidEntryPoint
import org.koin.android.ext.android.inject
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @Named("String1")
    lateinit var sampleName: String

    private val presenter1: Presenter1 by inject()
    private val presenter2: Presenter2 by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltTutorialTheme {

                val viewModel = hiltViewModel<MyViewModel>()
                Column {
                    Text(text = sampleName)
                    Text(text = presenter1.name)
                    Text(text = presenter2.name)
                    Button(onClick = {
                        presenter1.name = presenter1.name + "new"
                        presenter2.name = presenter2.name + "new"
                        startActivity(Intent(this@MainActivity, KoinActivity::class.java))
                    }) {
                        Text(text = "KoinActivity")
                    }
                }

            }
        }
    }
}