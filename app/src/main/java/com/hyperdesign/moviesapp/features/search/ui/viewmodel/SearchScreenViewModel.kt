package com.hyperdesign.moviesapp.features.search.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.navigation.HomeGraph
import com.hyperdesign.moviesapp.common.ui.navigation.HomeGraph.*
import com.hyperdesign.moviesapp.common.ui.viewmodel.BaseViewModel
import com.hyperdesign.moviesapp.features.search.domain.usecase.SearchByTiitleUseCase
import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchScreenViewModel(
    private val searchByTitleUseCase: SearchByTiitleUseCase
) : BaseViewModel<SearchScreenContract.SearchScreenState, SearchScreenContract.SearchScreenAction>(
    SearchScreenContract.SearchScreenState()
) {

    private var searchJob: Job? = null

    override fun onActionTrigger(action: SearchScreenContract.SearchScreenAction) {
        when (action) {
            is SearchScreenContract.SearchScreenAction.changeQuery -> {
                val query = action.query.trim()
                updateState { copy(query = query) }
                debounceSearch(query)
            }

            is SearchScreenContract.SearchScreenAction.navigateToMovieDetails -> {
                fireNavigate(MovieDetailsDestination(action.movieId))
            }

            is SearchScreenContract.SearchScreenAction.changeMovieId ->{
                changeeMovieId(action.movieId)
            }
        }
    }

    private fun changeeMovieId(movieId: String) {
        updateState {
            copy(movieId = movieId)
        }
    }

    private fun debounceSearch(query: String) {
        searchJob?.cancel()

        if (query.isEmpty()) {
            updateState { copy(searchResult = null) }
            return
        }

        searchJob = viewModelScope.launch(Dispatchers.IO) {
            delay(800L)

            // Only proceed if query hasn't changed during delay
            val currentQuery = state.value.query
            if (currentQuery == query) {
                searchByTitleUseCase.invoke(query).collectResource(
                    onLoading = ::onLoading,
                    onSuccess = ::searchByTitleSuccess,

                )
            }
        }
    }

    private fun searchByTitleSuccess(searchByTitleResponse: SearchByTitleResponse) {
        updateState {
            copy(searchResult = searchByTitleResponse)
        }
    }

    private fun onLoading(isLoading: Boolean) {
        fireLoading(loadingEventType = ILoadingEvent.CircularProgressIndicator(isLoading = isLoading))
    }

    override fun onCleared() {
        searchJob?.cancel()
        super.onCleared()
    }
}