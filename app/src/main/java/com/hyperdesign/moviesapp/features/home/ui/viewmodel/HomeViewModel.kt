package com.hyperdesign.moviesapp.features.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.viewmodel.BaseViewModel
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
): BaseViewModel<HomeScreenContract.HomeScreenState, HomeScreenContract.HomeScreenAction>(HomeScreenContract.HomeScreenState()) {


    init {
        getHomeFilms()
    }

    override fun onActionTrigger(action: HomeScreenContract.HomeScreenAction) {
        when(action){
            is HomeScreenContract.HomeScreenAction.chabgeQuery -> {

                changeSeqrchQuery(action.query)

            }

        }
    }



    fun getHomeFilms()=viewModelScope.launch(Dispatchers.IO) {
        getMoviesUseCase.invoke(body = Unit).collectResource(
            onSuccess =::showHomFilmsSuccess,
            onLoading =::onLoading
        )
    }



    private fun onLoading(isLoading: Boolean) = fireLoading(
        loadingEventType = ILoadingEvent.CircularProgressIndicator(isLoading = isLoading))


    fun showHomFilmsSuccess(
        homeFilms: HomeFilms
    ){
        updateState {
            copy(
                movies = homeFilms
            )
        }
    }

    fun changeSeqrchQuery(query:String){
        updateState {
            copy(
                query = query
            )
        }
    }
}