package com.hyperdesign.moviesapp.features.home.domain.repo.remote

import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryByIdResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.HomeFilmsDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.MovieDetailsResponseDto

interface IHomeApiService {

    suspend fun GetHomeMovies(): HomeFilmsDto

    suspend fun getCategories(): CategoryResponseDto


    suspend fun getFilmsByCategory(categoryId: String): CategoryByIdResponseDto

    suspend fun getMovieDetails(movieId: String): MovieDetailsResponseDto
}