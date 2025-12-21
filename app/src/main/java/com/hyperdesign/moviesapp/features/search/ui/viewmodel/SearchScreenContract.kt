package com.hyperdesign.moviesapp.features.search.ui.viewmodel

import com.hyperdesign.moviesapp.features.home.ui.viewmodel.HomeScreenContract.HomeScreenAction
import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse

sealed interface SearchScreenContract {

    data class SearchScreenState(
        val query: String="",
        val searchResult: SearchByTitleResponse?=null,
        val movieId: String=""


    ) : SearchScreenContract

    sealed interface SearchScreenAction {
        data class changeQuery(val query: String) : SearchScreenAction

        data class navigateToMovieDetails(val movieId: String): SearchScreenAction

        data class changeMovieId(val movieId: String): SearchScreenAction


    }
}