package com.hyperdesign.moviesapp.features.launchflow.splash.ui.viewmodel

sealed interface SplashScreenContract {
    data class SplashScreenState(val isLoading: Boolean = false) : SplashScreenContract
}