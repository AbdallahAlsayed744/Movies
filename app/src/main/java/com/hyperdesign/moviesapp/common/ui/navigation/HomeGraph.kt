package com.hyperdesign.moviesapp.common.ui.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hyperdesign.moviesapp.features.home.ui.screen.HomeScreen
import kotlinx.serialization.Serializable

interface HomeGraph {

    @Serializable
    data object OnBHomeGraph : IGraph
    @Serializable
    data object HomeDestination : IDestination


    @Serializable
    data object SearchDestination : IDestination

    @Serializable
    data object SaveDDestination : IDestination


}
fun NavGraphBuilder.buildNavHomeGraph() {
    navigation<HomeGraph.OnBHomeGraph>(startDestination = HomeGraph.HomeDestination) {
        composable<HomeGraph.HomeDestination> {

            HomeScreen()

//            HomeScreen()
        }

        composable<HomeGraph.SearchDestination> {
            Text("Search")

            //SearchDestination
        }

        composable<HomeGraph.SaveDDestination> {
            Text("Watch List")

            //SavedScreen
        }



    }
}