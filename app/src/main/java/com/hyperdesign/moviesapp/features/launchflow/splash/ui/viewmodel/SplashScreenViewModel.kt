package com.hyperdesign.moviesapp.features.launchflow.splash.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.hyperdesign.moviesapp.common.ui.navigation.HomeGraph
import com.hyperdesign.moviesapp.common.ui.viewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel(

): BaseViewModel<SplashScreenContract.SplashScreenState, Unit>(SplashScreenContract.SplashScreenState()) {


    init {
        viewModelScope.launch {
            delay(3000)
            fireNavigate(HomeGraph.HomeDestination)
        }
    }
    override fun onActionTrigger(action: Unit) {
        TODO("Not yet implemented")
    }


}