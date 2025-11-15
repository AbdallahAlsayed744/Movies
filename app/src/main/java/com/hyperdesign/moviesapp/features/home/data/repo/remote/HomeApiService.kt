package com.hyperdesign.moviesapp.features.home.data.repo.remote

import com.hyperdesign.moviesapp.common.domain.repo.remote.IRemoteDataSourceProvider
import com.hyperdesign.moviesapp.features.home.data.model.dto.HomeFilmsDto
import com.hyperdesign.moviesapp.features.home.domain.repo.remote.IHomeApiService

class HomeApiService(private val remoteDataSourceProvider: IRemoteDataSourceProvider): IHomeApiService {
    override suspend fun GetHomeMovies(): HomeFilmsDto {
        return remoteDataSourceProvider.get<HomeFilmsDto>(
            endpoint = "titles",
            serializer = HomeFilmsDto.serializer()
        )
    }
}