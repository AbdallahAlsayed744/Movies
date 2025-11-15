package com.hyperdesign.moviesapp.common.domain.model

import com.hyperdesign.moviesapp.common.data.model.exception.MoviesException


sealed class Resource<out Model> {
    data class Success<out Model>(val model: Model) : Resource<Model>()
    data class Failure(val exception: MoviesException) : Resource<Nothing>()
    data class Loading(val isLoading: Boolean = false) : Resource<Nothing>()
}