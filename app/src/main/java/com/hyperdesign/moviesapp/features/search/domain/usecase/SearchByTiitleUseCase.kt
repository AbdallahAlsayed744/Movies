package com.hyperdesign.moviesapp.features.search.domain.usecase

import com.hyperdesign.moviesapp.common.domain.model.Resource
import com.hyperdesign.moviesapp.common.domain.usecase.BaseUseCase
import com.hyperdesign.moviesapp.features.search.domain.repo.ISearchRepo
import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse
import kotlinx.coroutines.flow.Flow

class SearchByTiitleUseCase(
    private val searchRepo: ISearchRepo
): BaseUseCase<Flow<Resource<SearchByTitleResponse>>, String>() {


    override suspend fun invoke(body: String): Flow<Resource<SearchByTitleResponse>> {
        return flowExecute {
            searchRepo.searchByTitle(body)
        }
    }


}