package com.hyperdesign.moviesapp.features.home.domain.model



data class MovieDetailsResponse(
    val directors: List<Director>,
    val genres: List<String>,
    val id: String,
    val interests: List<Interst>,
    val plot: String,
    val primaryImage: PrimaryImage,
    val primaryTitle: String,
    val rating: Rating,
    val startYear: Int,
    val type: String,
    val writers: List<Writer>?=null
)
