package com.hyperdesign.moviesapp.features.search.data.model

import com.hyperdesign.moviesapp.features.home.data.model.dto.TitleDto
import kotlinx.serialization.Serializable

@Serializable
data class SearchByTitleResponseDto(
    val titles: List<TitleDto>
)
