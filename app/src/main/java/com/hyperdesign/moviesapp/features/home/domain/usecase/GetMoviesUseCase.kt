package com.hyperdesign.moviesapp.features.home.domain.usecase

import com.hyperdesign.moviesapp.common.domain.model.Resource
import com.hyperdesign.moviesapp.common.domain.usecase.BaseUseCase
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.repo.IHomeRepo
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val iHomeRepo: IHomeRepo ): BaseUseCase<Flow<Resource<HomeFilms>>, Unit>() {
    override suspend fun invoke(body: Unit): Flow<Resource<HomeFilms>> =
        flowExecute {
            iHomeRepo.getHomeFilms()
        }


}