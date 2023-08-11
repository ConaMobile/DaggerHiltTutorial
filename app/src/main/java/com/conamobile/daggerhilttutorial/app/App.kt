package com.conamobile.daggerhilttutorial.app

import android.app.Application
import com.conamobile.daggerhilttutorial.koin.appModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.core.context.startKoin

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}