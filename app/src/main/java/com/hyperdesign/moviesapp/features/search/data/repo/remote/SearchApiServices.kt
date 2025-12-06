package com.hyperdesign.moviesapp.features.search.data.repo.remote

import com.hyperdesign.moviesapp.common.domain.repo.remote.IRemoteDataSourceProvider
import com.hyperdesign.moviesapp.features.search.data.model.SearchByTitleResponseDto
import com.hyperdesign.moviesapp.features.search.domain.repo.remote.ISearchApiServices

class SearchApiServices(
    private val remoteDataSourceProvider: IRemoteDataSourceProvider
) : ISearchApiServices {
    override suspend fun searchByTitle(query: String): SearchByTitleResponseDto {
       return remoteDataSourceProvider.get<SearchByTitleResponseDto>(
            endpoint = "search/titles",
            params = mapOf("query" to query),
            serializer = SearchByTitleResponseDto.serializer()
        )
    }

}