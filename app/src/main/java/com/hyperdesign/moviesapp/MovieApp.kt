package com.hyperdesign.moviesapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hyperdesign.moviesapp.common.ui.component.appbar.bottombar.MoviesBottomNavigationBar
import com.hyperdesign.moviesapp.common.ui.extention.ObserveAsEvents
import com.hyperdesign.moviesapp.common.ui.navigation.INavigator
import com.hyperdesign.moviesapp.common.ui.navigation.NavigationEvent
import com.hyperdesign.moviesapp.common.ui.navigation.buildNavBoardingGraph
import com.hyperdesign.moviesapp.common.ui.navigation.buildNavHomeGraph
import com.hyperdesign.moviesapp.common.ui.theme.MoviesAppTheme
import org.koin.compose.koinInject


val LocalPadding = compositionLocalOf<PaddingValues> {  PaddingValues()  }

@Composable
fun MoviesApp(
    navigator: INavigator = koinInject(),

    navHostController: NavHostController = rememberNavController(),

    ){

    MoviesAppTheme{

        ObserveAsEvents(navigator.navigationEvent) { event ->
            when (event) {
                is NavigationEvent.Navigate -> navHostController.navigate(
                    route = event.destination, builder = event.builder
                )

                NavigationEvent.NavigateUp -> navHostController.navigateUp()
            }
        }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                MoviesBottomNavigationBar(
                    navHostController = navHostController,
                    navigator = navigator
                )

            },
            topBar = {

            }
        ){ innerPadding ->
            CompositionLocalProvider(LocalPadding provides  innerPadding) {
                NavHost(
                    navController = navHostController,
                    startDestination = navigator.startGraph,
                ) {
                    buildNavBoardingGraph()
                    buildNavHomeGraph()

                }
            }

        }





    }
}