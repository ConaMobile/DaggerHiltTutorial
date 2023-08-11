package com.conamobile.daggerhilttutorial.koin

import org.koin.dsl.module

val appModule = module {
    single { Presenter1() }
    factory { Presenter2() }
}