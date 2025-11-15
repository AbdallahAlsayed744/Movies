package com.hyperdesign.moviesapp.features.home.domain.model


data class HomeFilms(

    val nextPageToken: String,
    val titles: List<Title>,
    val totalCount: Int
)
