package com.hyperdesign.moviesapp.features.home.domain.model

data class SimilarInterest(
    val description: String,
    val id: String,
    val isSubgenre: Boolean?=null,
    val name: String,
    val primaryImage: PrimaryImage
)
