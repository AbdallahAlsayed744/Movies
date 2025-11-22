package com.hyperdesign.moviesapp.features.home.domain.repo.remote

import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.HomeFilmsDto

interface IHomeApiService {

    suspend fun GetHomeMovies(): HomeFilmsDto

    suspend fun getCategories(): CategoryResponseDto
}