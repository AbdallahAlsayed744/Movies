package com.hyperdesign.moviesapp.features.home.data.mappers

import com.hyperdesign.moviesapp.features.home.data.model.dto.DirectorDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.MovieDetailsResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.WriterDto
import com.hyperdesign.moviesapp.features.home.domain.model.Director
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse
import com.hyperdesign.moviesapp.features.home.domain.model.Writer

object MovieResponseMapper{
    fun toMovieDetailsResponse(movieDetailsResponseDto: MovieDetailsResponseDto): MovieDetailsResponse {
        return MovieDetailsResponse(
            directors =movieDetailsResponseDto.directors.map {
                DirectorMapper.toDirector(it)
            } ,
            genres = movieDetailsResponseDto.genres,
            id = movieDetailsResponseDto.id,
            interests = movieDetailsResponseDto.interests.map {
                InterestMapper.toDomain(it)
            },
            plot = movieDetailsResponseDto.plot,
            primaryImage = PrimaryImageMapper.toDomain(movieDetailsResponseDto.primaryImage) ,
            primaryTitle = movieDetailsResponseDto.primaryTitle,
            rating = RatingMapper.toDomain(movieDetailsResponseDto.rating) ,
            startYear = movieDetailsResponseDto.startYear,
            type = movieDetailsResponseDto.type,
            writers = movieDetailsResponseDto.writers?.map {
                WritersMapper.toWriter(it)
            }
        )
    }
}


object DirectorMapper{
    fun toDirector(directorDto: DirectorDto): Director {
        return Director(
            displayName = directorDto.displayName,
            id = directorDto.id,
            primaryProfessions = directorDto.primaryProfessions
        )
    }

}

object WritersMapper{
    fun toWriter(writerDto: WriterDto): Writer {
        return Writer(
            displayName = writerDto.displayName,
            id = writerDto.id,
            primaryImage = writerDto.primaryImage?.let { PrimaryImageMapper.toDomain(it) },
            alternativeNames = writerDto.alternativeNames,
            primaryProfessions = writerDto.primaryProfessions?.map { it }
        )
    }
}


