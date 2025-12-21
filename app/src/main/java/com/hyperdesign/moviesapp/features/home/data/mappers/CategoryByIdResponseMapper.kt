package com.hyperdesign.moviesapp.features.home.data.mappers

import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryByIdResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.SimilarInterestDto
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryByIdResponse
import com.hyperdesign.moviesapp.features.home.domain.model.SimilarInterest


object CategoryByIdResponseMapper{
    fun toDomain(categoryByIdResponseDto: CategoryByIdResponseDto) = CategoryByIdResponse(
        description = categoryByIdResponseDto.description,
        id = categoryByIdResponseDto.id,
        name = categoryByIdResponseDto.name,
        primaryImage = PrimaryImageMapper.toDomain(categoryByIdResponseDto.primaryImage) ,
        similarInterests = categoryByIdResponseDto.similarInterests.map {
            SimilarInterestMapper.toDomain(it)
        }
    )

}

object SimilarInterestMapper{
    fun toDomain(similarInterestDto: SimilarInterestDto) = SimilarInterest(
        description = similarInterestDto.description,
        id = similarInterestDto.id,
        isSubgenre = similarInterestDto.isSubgenre,
        name = similarInterestDto.name,
        primaryImage =PrimaryImageMapper.toDomain( similarInterestDto.primaryImage)
    )

}

