package com.hyperdesign.moviesapp.features.home.domain.usecase

import com.hyperdesign.moviesapp.common.domain.model.Resource
import com.hyperdesign.moviesapp.common.domain.usecase.BaseUseCase
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryByIdResponse
import com.hyperdesign.moviesapp.features.home.domain.repo.IHomeRepo
import kotlinx.coroutines.flow.Flow

class GetFilmsByCategoryUseCase(
    private val homeRepo: IHomeRepo
): BaseUseCase<Flow<Resource<CategoryByIdResponse>>, String>(){

    override suspend fun invoke(body: String): Flow<Resource<CategoryByIdResponse>> {
       return flowExecute {
           homeRepo.getFilmsByCategory(body)
       }
    }
}