package com.hyperdesign.moviesapp.features.home.domain.model

import com.hyperdesign.moviesapp.features.home.data.model.dto.InterestDto

data class Category(
    val category: String,
    val interests: List<Interst>
)
