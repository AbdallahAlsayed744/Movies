package com.hyperdesign.moviesapp.features.home.domain.repo.remote

import com.hyperdesign.moviesapp.features.home.data.model.dto.HomeFilmsDto

interface IHomeApiService {

    suspend fun GetHomeMovies(): HomeFilmsDto
}