package com.hyperdesign.moviesapp.features.search.model

import com.hyperdesign.moviesapp.features.home.domain.model.Title

data class SearchByTitleResponse(

    val titles : List<Title>
)
