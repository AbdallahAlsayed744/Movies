package com.hyperdesign.moviesapp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hyperdesign.moviesapp.common.ui.component.appbar.bottombar.MoviesBottomNavigationBar
import com.hyperdesign.moviesapp.common.ui.dialoge.loading.MoviesLoadingDialog
import com.hyperdesign.moviesapp.common.ui.errorhandling.model.UIText
import com.hyperdesign.moviesapp.common.ui.eventcontroller.IEventController
import com.hyperdesign.moviesapp.common.ui.extention.ObserveAsEvents
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.messages.IMessageEvent
import com.hyperdesign.moviesapp.common.ui.navigation.INavigator
import com.hyperdesign.moviesapp.common.ui.navigation.NavigationEvent
import com.hyperdesign.moviesapp.common.ui.navigation.buildNavBoardingGraph
import com.hyperdesign.moviesapp.common.ui.navigation.buildNavHomeGraph
import com.hyperdesign.moviesapp.common.ui.theme.MoviesAppTheme
import org.koin.compose.koinInject
import org.koin.core.qualifier.named


val LocalPadding = compositionLocalOf<PaddingValues> {  PaddingValues()  }

@Composable
fun MoviesApp(
    navigator: INavigator = koinInject(),

    navHostController: NavHostController = rememberNavController(),

    ){

    MoviesAppTheme{
        ObserveMessageEvent()
        ObserveLoadingEvent()

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

@Composable
private fun ObserveMessageEvent() {
    val context = LocalContext.current
    fun UIText.toMessageString(): String {
        return when (this) {
            is UIText.DynamicString -> this.value
            is UIText.StringResource -> context.getString(this.id)
        }
    }

    val messageEvent: IEventController<IMessageEvent> =
        koinInject(qualifier = named("MessageEvent"))
    ObserveAsEvents(messageEvent.event) { event ->
        when (event) {
            is IMessageEvent.Toast -> {
                Log.e("error",event.message.toMessageString())
                Toast.makeText(context, event.message.toMessageString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
private fun ObserveLoadingEvent() {
    val loadingEvent: IEventController<ILoadingEvent> =
        koinInject(qualifier = named("LoadingEvent"))
    var isLoading by remember { mutableStateOf(false) }
    ObserveAsEvents(loadingEvent.event) { event ->
        when (event) {
            is ILoadingEvent.CircularProgressIndicator -> isLoading = event.isLoading
        }
    }
    if (isLoading) MoviesLoadingDialog()
}