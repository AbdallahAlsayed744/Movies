package com.hyperdesign.moviesapp.features.home.domain.repo

import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms

interface IHomeRepo {

    suspend fun getHomeFilms(): HomeFilms

    suspend fun getCategories(): CategoryResponse
}