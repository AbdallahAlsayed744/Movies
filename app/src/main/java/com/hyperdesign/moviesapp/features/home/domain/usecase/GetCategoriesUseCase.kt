package com.hyperdesign.moviesapp.features.home.domain.usecase

import com.hyperdesign.moviesapp.common.domain.model.Resource
import com.hyperdesign.moviesapp.common.domain.usecase.BaseUseCase
import com.hyperdesign.moviesapp.features.home.data.repo.HomeRepo
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import kotlinx.coroutines.flow.Flow

class GetCategoriesUseCase(
    private val homeRepo: HomeRepo
): BaseUseCase<Flow<Resource<CategoryResponse>>, Unit>() {
    override suspend fun invoke(body: Unit): Flow<Resource<CategoryResponse>> {
        return flowExecute {
            homeRepo.getCategories()
        }
    }
}