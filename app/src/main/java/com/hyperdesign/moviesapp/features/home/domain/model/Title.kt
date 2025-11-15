package com.hyperdesign.moviesapp.features.home.domain.model



data class Title(

    val endYear: Int,
    val genres: List<String>,
    val id: String,
    val originalTitle: String,
    val plot: String,
    val primaryImage: PrimaryImage,
    val primaryTitle: String,
    val rating: Rating,
    val runtimeSeconds: Int,
    val startYear: Int,
    val type: String
)
