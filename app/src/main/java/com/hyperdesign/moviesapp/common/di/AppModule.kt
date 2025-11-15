package com.hyperdesign.moviesapp.common.di

import com.hyperdesign.moviesapp.common.ui.eventcontroller.EventController
import com.hyperdesign.moviesapp.common.ui.eventcontroller.IEventController
import com.hyperdesign.moviesapp.common.ui.langauge.ILanguageEvent
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.messages.IMessageEvent
import com.hyperdesign.moviesapp.common.ui.navigation.INavigator
import com.hyperdesign.moviesapp.common.ui.navigation.IOnBoardingGraph
import com.hyperdesign.moviesapp.common.ui.navigation.Navigator
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single<INavigator> { Navigator(startGraph = IOnBoardingGraph.OnBoardingGraph) }
    single<IEventController<IMessageEvent>>(qualifier = named("MessageEvent")) { EventController() }
    single<IEventController<ILoadingEvent>>(qualifier = named("LoadingEvent")){ EventController() }
    single<IEventController<ILanguageEvent>>(qualifier = named("LanguageEvent")) { EventController() }
    single<Json> {
        Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
            encodeDefaults = true
        }
    }
}