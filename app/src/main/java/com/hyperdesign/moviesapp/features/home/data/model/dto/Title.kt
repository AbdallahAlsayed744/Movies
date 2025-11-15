package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class TitleDto(
    val endYear: Int,
    val genres: List<String>,
    val id: String,
    val originalTitle: String,
    val plot: String,
    val primaryImage: PrimaryImageDto,
    val primaryTitle: String,
    val rating: RatingDto,
    val runtimeSeconds: Int,
    val startYear: Int,
    val type: String
)