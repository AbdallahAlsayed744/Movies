package com.hyperdesign.moviesapp.features.home.data.mappers

import com.hyperdesign.moviesapp.features.home.data.model.dto.HomeFilmsDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.PrimaryImageDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.RatingDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.TitleDto
import com.hyperdesign.moviesapp.features.home.domain.model.HomeFilms
import com.hyperdesign.moviesapp.features.home.domain.model.PrimaryImage
import com.hyperdesign.moviesapp.features.home.domain.model.Rating
import com.hyperdesign.moviesapp.features.home.domain.model.Title

object HomeResponseMapper {

    fun toDomain(HomeResponsedto: HomeFilmsDto)=HomeFilms(
        nextPageToken = HomeResponsedto.nextPageToken,
        totalCount = HomeResponsedto.totalCount,
        titles = HomeResponsedto.titles.map { TitleMapper.toDomain(it) }
    )
}


object TitleMapper{
    fun toDomain(titleDto: TitleDto)= Title(
        endYear = titleDto.endYear,
        genres = titleDto.genres,
        id = titleDto.id,
        originalTitle = titleDto.originalTitle,
        plot = titleDto.plot,
        primaryTitle = titleDto.primaryTitle,
        primaryImage = PrimaryImageMapper.toDomain(titleDto.primaryImage),
        rating = RatingMapper.toDomain(titleDto.rating),
        runtimeSeconds = titleDto.runtimeSeconds,
        startYear = titleDto.startYear,
        type = titleDto.type
    )
}

object RatingMapper{
    fun toDomain(ratingDto: RatingDto)= Rating(
        aggregateRating = ratingDto.aggregateRating,
        voteCount = ratingDto.voteCount
    )

}

object PrimaryImageMapper{
    fun toDomain(image: PrimaryImageDto)= PrimaryImage(
        height = image.height,
        url = image.url,
        width = image.width
    )
}


