package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class WriterDto(
    val alternativeNames: List<String>? = null,
    val displayName: String?=null,
    val id: String,
    val primaryImage: PrimaryImageDto?=null,
    val primaryProfessions: List<String>? = null
)