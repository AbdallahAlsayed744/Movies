package com.hyperdesign.moviesapp.features.home.domain.repo

import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryByIdResponseDto
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryByIdResponse
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

interface IHomeRepo {

    suspend fun getHomeFilms(): HomeFilms

    suspend fun getCategories(): CategoryResponse

    suspend fun getFilmsByCategory(categoryId: String): CategoryByIdResponse

    suspend fun getMovieDetails(movieId: String): MovieDetailsResponse
}