package com.hyperdesign.moviesapp.features.search.ui.viewmodel

import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse

sealed interface SearchScreenContract {

    data class SearchScreenState(
        val query: String="",
        val searchResult: SearchByTitleResponse?=null
    ) : SearchScreenContract

    sealed interface SearchScreenAction {
        data class changeQuery(val query: String) : SearchScreenAction
    }
}