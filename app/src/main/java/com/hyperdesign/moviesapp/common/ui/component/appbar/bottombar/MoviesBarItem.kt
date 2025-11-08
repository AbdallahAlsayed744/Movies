package com.hyperdesign.moviesapp.common.ui.component.appbar.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.hyperdesign.moviesapp.R
import com.hyperdesign.moviesapp.common.ui.navigation.HomeGraph
import com.hyperdesign.moviesapp.common.ui.navigation.IDestination

sealed class MoviesNavigationBarItem(
    @DrawableRes val icon: Int,
    @StringRes val label: Int,
    val destination: IDestination

) {
    data object HomeScreen : MoviesNavigationBarItem(
        icon = R.drawable.home,
        label = R.string.home,
        destination = HomeGraph.HomeDestination
    )

    data object SearchScreen : MoviesNavigationBarItem(
        icon = R.drawable.search,
        label = R.string.search,
        destination = HomeGraph.SearchDestination
    )

    data object SavedScreen : MoviesNavigationBarItem(
        icon = R.drawable.save,
        label = R.string.watch_list,
        destination = HomeGraph.SaveDDestination
    )

    companion object {
        val destinations = listOf(HomeScreen, SearchScreen, SavedScreen)
    }
}