package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable

data class CategoryResponseDto(
    val categories: List<CategoryDto>
)