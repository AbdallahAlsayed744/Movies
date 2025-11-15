package com.hyperdesign.moviesapp.features.home.ui.viewmodel

import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms

sealed interface HomeScreenContract {

    data class HomeScreenState(

        val query:String ="",
        val movies : HomeFilms?=null,

    ):HomeScreenContract


    sealed interface HomeScreenAction:HomeScreenContract{

        data class chabgeQuery(val query:String):HomeScreenAction

//        data object getFilms:HomeScreenAction



    }


}