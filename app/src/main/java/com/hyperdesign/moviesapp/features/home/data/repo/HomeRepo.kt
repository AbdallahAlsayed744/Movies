package com.hyperdesign.moviesapp.features.home.data.repo


import com.hyperdesign.moviesapp.features.home.data.mappers.CategoryByIdResponseMapper
import com.hyperdesign.moviesapp.features.home.data.mappers.CatogoryResponseMapper
import com.hyperdesign.moviesapp.features.home.data.mappers.HomeResponseMapper
import com.hyperdesign.moviesapp.features.home.data.mappers.MovieResponseMapper
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryByIdResponse
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse
import com.hyperdesign.moviesapp.features.home.domain.repo.IHomeRepo
import com.hyperdesign.moviesapp.features.home.domain.repo.remote.IHomeApiService

class HomeRepo(private val homeApiSerice: IHomeApiService): IHomeRepo {
    override suspend fun getHomeFilms(): HomeFilms {
        val homeResponse = homeApiSerice.GetHomeMovies()
        return HomeResponseMapper.toDomain(homeResponse)
    }

    override suspend fun getCategories(): CategoryResponse {
        val categoryResponse = homeApiSerice.getCategories()
        return CatogoryResponseMapper.toDonmain(categoryResponse)
    }

    override suspend fun getFilmsByCategory(categoryId: String): CategoryByIdResponse {
        val categoryByIdResponse = homeApiSerice.getFilmsByCategory(categoryId)
        return CategoryByIdResponseMapper.toDomain(categoryByIdResponse)
    }

    override suspend fun getMovieDetails(movieId: String): MovieDetailsResponse {
        val movieDetailsResponseDto = homeApiSerice.getMovieDetails(movieId)
        return MovieResponseMapper.toMovieDetailsResponse(movieDetailsResponseDto)
    }
}