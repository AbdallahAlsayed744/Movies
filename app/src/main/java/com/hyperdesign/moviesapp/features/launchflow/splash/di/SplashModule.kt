package com.hyperdesign.moviesapp.features.launchflow.splash.di

import com.hyperdesign.moviesapp.features.launchflow.splash.ui.viewmodel.SplashScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val splashModule = module {
    viewModelOf(::SplashScreenViewModel)
}