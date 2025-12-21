package com.hyperdesign.moviesapp.features.home.ui.viewmodel

import com.hyperdesign.moviesapp.features.home.domain.model.CategoryByIdResponse
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms

sealed interface HomeScreenContract {

    data class HomeScreenState(

        val query:String ="",
        val movies : HomeFilms?=null,
        val cateogreies: CategoryResponse?=null,
        val categoryByIdResponse: CategoryByIdResponse?=null,
        val categoryChangeNumber:Int = 0,
        val changeCategoryId:String ="",
        val movieId: String=""

    ):HomeScreenContract


    sealed interface HomeScreenAction:HomeScreenContract{

        data class chabgeQuery(val query:String):HomeScreenAction

        data class chabgeCategoryNumber(val categoryChangeNumber:Int):HomeScreenAction




        data class ChangeCategoryId(val categoryId: String): HomeScreenAction


        data class changeMovieId(val movieId: String): HomeScreenAction
        data class navigateToMovieDetails(val movieId: String): HomeScreenAction




    }


}