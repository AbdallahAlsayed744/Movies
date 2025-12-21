package com.hyperdesign.moviesapp.features.home.ui.viewmodel

import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

sealed interface HomeScreenDetailsContract {

    data class HomeScreenDetailsState(

       val homeScreenDetailsResponse : MovieDetailsResponse? =null

    ):HomeScreenDetailsContract




}