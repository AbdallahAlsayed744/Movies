package com.hyperdesign.moviesapp.common.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hyperdesign.moviesapp.features.launchflow.splash.ui.screen.SplashScreen
import kotlinx.serialization.Serializable

interface IOnBoardingGraph {

    @Serializable
    data object OnBoardingGraph : IGraph
    @Serializable
    data object SplashScreenDestination : IDestination


}
fun NavGraphBuilder.buildNavBoardingGraph() {
    navigation<IOnBoardingGraph.OnBoardingGraph>(startDestination = IOnBoardingGraph.SplashScreenDestination) {
        composable<IOnBoardingGraph.SplashScreenDestination> {
            SplashScreen()
        }

    }
}



