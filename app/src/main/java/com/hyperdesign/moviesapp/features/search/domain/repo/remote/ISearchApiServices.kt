package com.hyperdesign.moviesapp.features.search.domain.repo.remote

import com.hyperdesign.moviesapp.features.search.data.model.SearchByTitleResponseDto

interface ISearchApiServices {

    suspend fun searchByTitle(query: String) : SearchByTitleResponseDto
}