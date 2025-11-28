package com.hyperdesign.moviesapp.features.home.domain.model

data class CategoryByIdResponse(
    val description: String,
    val id: String,
    val name: String,
    val primaryImage: PrimaryImage,
    val similarInterests: List<SimilarInterest>
)
