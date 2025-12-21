package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable


@Serializable
data class DirectorDto(
    val displayName: String,
    val id: String,
    val primaryProfessions: List<String>
)