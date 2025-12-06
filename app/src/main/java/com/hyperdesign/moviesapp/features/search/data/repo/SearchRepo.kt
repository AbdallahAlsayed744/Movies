package com.hyperdesign.moviesapp.features.search.data.repo

import com.hyperdesign.moviesapp.features.search.data.mapper.SearchResponseMapper
import com.hyperdesign.moviesapp.features.search.domain.repo.ISearchRepo
import com.hyperdesign.moviesapp.features.search.domain.repo.remote.ISearchApiServices
import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse

class SearchRepo(
    private val searchApiServices: ISearchApiServices
) : ISearchRepo{
    override suspend fun searchByTitle(query: String): SearchByTitleResponse {

        val response = searchApiServices.searchByTitle(query)
        return SearchResponseMapper.toDomain(response)
    }


}