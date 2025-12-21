package com.hyperdesign.moviesapp.features.home.domain.usecase

import com.hyperdesign.moviesapp.common.domain.model.Resource
import com.hyperdesign.moviesapp.common.domain.usecase.BaseUseCase
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse
import com.hyperdesign.moviesapp.features.home.domain.repo.IHomeRepo
import kotlinx.coroutines.flow.Flow

class GetMovieDetailsUseCase(
    private val homeRepo: IHomeRepo
): BaseUseCase<Flow<Resource<MovieDetailsResponse>>, String>() {
    override suspend fun invoke(body: String): Flow<Resource<MovieDetailsResponse>> {
        return flowExecute {
            homeRepo.getMovieDetails(body)

        }
    }
}