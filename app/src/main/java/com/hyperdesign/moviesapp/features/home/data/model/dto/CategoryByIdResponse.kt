package com.hyperdesign.moviesapp.features.home.data.model.dto

import com.hyperdesign.moviesapp.features.home.domain.model.PrimaryImage
import kotlinx.serialization.Serializable

@Serializable
data class CategoryByIdResponseDto(
    val description: String,
    val id: String,
    val name: String,
    val primaryImage: PrimaryImageDto,
    val similarInterests: List<SimilarInterestDto>
)