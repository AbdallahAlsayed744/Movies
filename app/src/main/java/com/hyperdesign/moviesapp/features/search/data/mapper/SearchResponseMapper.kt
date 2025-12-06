package com.hyperdesign.moviesapp.features.search.data.mapper

import com.hyperdesign.moviesapp.features.home.data.mappers.TitleMapper
import com.hyperdesign.moviesapp.features.search.data.model.SearchByTitleResponseDto
import com.hyperdesign.moviesapp.features.search.model.SearchByTitleResponse


object SearchResponseMapper {
    fun toDomain(searchByTitleResponseDto: SearchByTitleResponseDto): SearchByTitleResponse{
        return SearchByTitleResponse(
            titles = searchByTitleResponseDto.titles.map {
                TitleMapper.toDomain(it)
            }
        )
    }

}