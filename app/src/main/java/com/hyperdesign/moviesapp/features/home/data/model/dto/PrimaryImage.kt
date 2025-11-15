package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class PrimaryImageDto(
    val height: Int,
    val url: String,
    val width: Int
)