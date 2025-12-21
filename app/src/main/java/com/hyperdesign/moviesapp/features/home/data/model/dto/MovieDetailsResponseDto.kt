package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable


@Serializable
data class MovieDetailsResponseDto(
    val directors: List<DirectorDto>,
    val genres: List<String>,
    val id: String,
    val interests: List<InterestDto>,
    val plot: String,
    val primaryImage: PrimaryImageDto,
    val primaryTitle: String,
    val rating: RatingDto,
    val startYear: Int,
    val type: String,
    val writers: List<WriterDto>? = null
)