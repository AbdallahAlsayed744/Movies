package com.hyperdesign.moviesapp.common.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

interface IOnBoardingGraph {

    @Serializable
    data object OnBoardingDistenation : IGraph
    @Serializable
    data object SplashScreenDestination : IDestination


}
fun NavGraphBuilder.buildNavBoardingGraph() {
    navigation<IOnBoardingGraph.OnBoardingDistenation>(startDestination = IOnBoardingGraph.SplashScreenDestination) {
        composable<IOnBoardingGraph.SplashScreenDestination> {
//            SplashScreen()
        }

    }
}



