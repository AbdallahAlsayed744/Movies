package com.hyperdesign.moviesapp.features.home.data.repo

import com.hyperdesign.moviesapp.features.home.data.mappers.HomeResponseMapper
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.repo.IHomeRepo
import com.hyperdesign.moviesapp.features.home.domain.repo.remote.IHomeApiService

class HomeRepo(private val homeApiSerice: IHomeApiService): IHomeRepo {
    override suspend fun getHomeFilms(): HomeFilms {
        val homeResponse = homeApiSerice.GetHomeMovies()
        return HomeResponseMapper.toDomain(homeResponse)
    }
}