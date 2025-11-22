package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class TitleDto(
    val id: String,
    val primaryTitle: String,
    val originalTitle: String,
    val type: String,
    val startYear: Int,
    val endYear: Int? = null,  // Make optional with default null
    val runtimeSeconds: Int? = null,  // Make optional in case it's missing
    val genres: List<String> = emptyList(),  // Provide default empty list
    val primaryImage: PrimaryImageDto? = null,  // Make optional
    val plot: String = "",  // Provide default empty string
    val rating: RatingDto? = null  // Make optional
)