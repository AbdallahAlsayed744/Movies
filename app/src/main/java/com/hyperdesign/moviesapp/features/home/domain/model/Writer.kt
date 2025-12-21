package com.hyperdesign.moviesapp.features.home.domain.model

import com.hyperdesign.moviesapp.features.home.data.model.dto.PrimaryImageDto

data class Writer(

    val alternativeNames: List<String>?=null,
    val displayName: String?=null,
    val id: String,
    val primaryImage: PrimaryImage?=null,
    val primaryProfessions: List<String>?=null
)
