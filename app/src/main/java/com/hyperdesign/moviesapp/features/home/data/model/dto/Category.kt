package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    val category: String,
    val interests: List<InterestDto>
)