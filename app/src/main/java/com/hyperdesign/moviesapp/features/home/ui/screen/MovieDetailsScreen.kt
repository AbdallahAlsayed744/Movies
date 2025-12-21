package com.hyperdesign.moviesapp.features.home.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.features.home.ui.component.MovieInfoSection
import com.hyperdesign.moviesapp.features.home.ui.viewmodel.HomeScreenDetailsContract
import com.hyperdesign.moviesapp.features.home.ui.viewmodel.MovieDetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel = koinViewModel()
) {
    val movieDetailsState by movieDetailsViewModel.state.collectAsState()

    MovieDetailsScreenContent(movieDetailsState = movieDetailsState)
}

@Composable
fun MovieDetailsScreenContent(
    movieDetailsState: HomeScreenDetailsContract.HomeScreenDetailsState
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(Color(0xFF1C1C1E))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            movieDetailsState.homeScreenDetailsResponse?.let { MovieInfoSection(movieDetails = it) }

        }
    }
}