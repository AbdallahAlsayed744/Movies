package com.hyperdesign.moviesapp.features.home.data.repo.remote

import com.hyperdesign.moviesapp.common.domain.repo.remote.IRemoteDataSourceProvider
import com.hyperdesign.moviesapp.features.home.data.mappers.CatogoryResponseMapper
import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryByIdResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.HomeFilmsDto
import com.hyperdesign.moviesapp.features.home.domain.repo.remote.IHomeApiService

class HomeApiService(private val remoteDataSourceProvider: IRemoteDataSourceProvider): IHomeApiService {
    override suspend fun GetHomeMovies(): HomeFilmsDto {
        return remoteDataSourceProvider.get<HomeFilmsDto>(
            endpoint = "titles",
            serializer = HomeFilmsDto.serializer()
        )
    }

    override suspend fun getCategories(): CategoryResponseDto {
        return remoteDataSourceProvider.get<CategoryResponseDto>(
            endpoint = "interests",
            serializer = CategoryResponseDto.serializer()
        )
    }

    override suspend fun getFilmsByCategory(categoryId: String): CategoryByIdResponseDto {
        return remoteDataSourceProvider.get<CategoryByIdResponseDto>(
            endpoint = "interests/$categoryId",
            serializer = CategoryByIdResponseDto.serializer()
        )
    }
}