package com.hyperdesign.moviesapp.features.home.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.viewmodel.BaseViewModel
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse
import com.hyperdesign.moviesapp.features.home.domain.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
): BaseViewModel<HomeScreenDetailsContract.HomeScreenDetailsState, Unit>(HomeScreenDetailsContract.HomeScreenDetailsState()) {


    private val movieId: String = checkNotNull(savedStateHandle["movieId"]) {
        "movieId is required"
    }

    override fun onActionTrigger(action: Unit) {

    }

    init {
        showMovieDetails()
    }


    private fun showMovieDetails(){
        viewModelScope.launch(Dispatchers.IO) {
            getMovieDetailsUseCase.invoke(movieId).collectResource(
                onSuccess = ::showMovieDetailsSuccess,
                onLoading = ::onLoading
            )
        }

    }

    private fun showMovieDetailsSuccess(movieDetailsResponse: MovieDetailsResponse){
        updateState {
            copy(
                homeScreenDetailsResponse = movieDetailsResponse
            )
        }
    }

    fun onLoading(isLoading: Boolean){
        fireLoading(
            loadingEventType = ILoadingEvent.CircularProgressIndicator(isLoading = isLoading)
        )
    }






}