package com.hyperdesign.moviesapp.features.home.data.mappers

import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.CategoryResponseDto
import com.hyperdesign.moviesapp.features.home.data.model.dto.InterestDto
import com.hyperdesign.moviesapp.features.home.domain.model.Category
import com.hyperdesign.moviesapp.features.home.domain.model.CategoryResponse
import com.hyperdesign.moviesapp.features.home.domain.model.Interst
object CatogoryResponseMapper{
    fun toDonmain(categoryResponseDto: CategoryResponseDto)= CategoryResponse(
        categories = categoryResponseDto.categories.map { CatogoryMapper.toDonmain(it) }
    )
}


object CatogoryMapper{
    fun toDonmain(categoryDto: CategoryDto)= Category(
        category = categoryDto.category,
        interests = categoryDto.interests.map { InterestMapper.toDomain(it) }
    )
}

object InterestMapper{
    fun toDomain(interestDto: InterestDto)= Interst(
        description = interestDto.description,
        id = interestDto.id,
        isSubgenre = interestDto.isSubgenre,
        name = interestDto.name,
        primaryImage = interestDto.primaryImage?.let { PrimaryImageMapper.toDomain(it) }
    )
}
