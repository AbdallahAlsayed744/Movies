package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class InterestDto(
    val id: String,
    val name: String,
    val description: String = "",  // Default empty string
    val isSubgenre: Boolean = false,  // Default false
    val primaryImage: PrimaryImageDto? = null  // Make nullable
)