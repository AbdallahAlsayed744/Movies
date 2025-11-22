package com.hyperdesign.moviesapp.features.home.domain.model



data class Title(

    val endYear: Int?=null,
    val genres: List<String> =  emptyList(),
    val id: String,
    val originalTitle: String,
    val plot: String="",
    val primaryImage: PrimaryImage?=null,
    val primaryTitle: String,
    val rating: Rating?=null,
    val runtimeSeconds: Int?=null,
    val startYear: Int,
    val type: String
)


