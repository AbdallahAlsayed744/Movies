package com.hyperdesign.moviesapp.features.search.domain.repo

import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse

interface ISearchRepo {

    suspend fun searchByTitle(query: String) : SearchByTitleResponse
}