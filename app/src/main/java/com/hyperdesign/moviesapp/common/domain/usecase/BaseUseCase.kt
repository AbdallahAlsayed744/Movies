package com.hyperdesign.moviesapp.common.domain.usecase

import com.hyperdesign.moviesapp.common.data.model.exception.MoviesException
import com.hyperdesign.moviesapp.common.domain.model.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.onStart

abstract class BaseUseCase<out Domain, in Body> {
    abstract suspend operator fun invoke(body: Body): Domain

    fun <Domain> flowExecute(codeBlock: suspend () -> Domain) = channelFlow {
        send(Resource.Success(codeBlock.invoke()))
        send(Resource.Loading(isLoading = false))
    }.onStart {
        emit(Resource.Loading(isLoading = true))
    }.catch { exception ->
        emit(handleFailure(exception))
        emit(Resource.Loading(isLoading = false))
    } //  return flow of results

    suspend fun <Domain> nonFlowExecute(codeBlock: suspend () -> Domain) = runCatching {
        val result = codeBlock.invoke()
        Resource.Success(result)
    }.getOrElse(::handleFailure) // return one result

    private fun handleFailure(exception: Throwable): Resource.Failure {
        val failureException =
            exception as? MoviesException ?: MoviesException.UnKnown(message = "Unknown Error $exception")
        return Resource.Failure(failureException)
    }
}