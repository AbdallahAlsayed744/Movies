package com.hyperdesign.moviesapp.features.home.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class HomeFilmsDto(
    val nextPageToken: String,
    val titles: List<TitleDto>,
    val totalCount: Int
)