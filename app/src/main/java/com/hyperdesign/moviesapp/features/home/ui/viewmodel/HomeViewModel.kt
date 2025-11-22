package com.hyperdesign.moviesapp.features.home.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.viewmodel.BaseViewModel
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.usecase.GetCategoriesUseCase
import com.hyperdesign.moviesapp.features.home.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
): BaseViewModel<HomeScreenContract.HomeScreenState, HomeScreenContract.HomeScreenAction>(HomeScreenContract.HomeScreenState()) {


    init {
        getHomeFilms()
        getCategories()
    }

    override fun onActionTrigger(action: HomeScreenContract.HomeScreenAction) {
        when(action){
            is HomeScreenContract.HomeScreenAction.chabgeQuery -> {

                changeSeqrchQuery(action.query)

            }

        }
    }



    private fun getHomeFilms()=viewModelScope.launch(Dispatchers.IO) {
        getMoviesUseCase.invoke(body = Unit).collectResource(

            onSuccess =::showHomFilmsSuccess,
            onLoading =::onLoading
        )
    }

    private fun getCategories()=viewModelScope.launch(Dispatchers.IO) {
        getCategoriesUseCase.invoke(Unit).collectResource(
            onSuccess = ::getCategoriesSuccess
        )
    }



    private fun getCategoriesSuccess(categoryResponse: CategoryResponse){
        updateState {
            copy(
                cateogreies = categoryResponse
            )
        }
    }
    private fun onLoading(isLoading: Boolean) = fireLoading(
        loadingEventType = ILoadingEvent.CircularProgressIndicator(isLoading = isLoading))


    private fun showHomFilmsSuccess(
        homeFilms: HomeFilms
    ){
        updateState {
            copy(
                movies = homeFilms
            )
        }
    }

    private fun changeSeqrchQuery(query:String){
        updateState {
            copy(
                query = query
            )
        }
    }
}