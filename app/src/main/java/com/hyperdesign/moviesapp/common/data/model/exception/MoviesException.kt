package com.hyperdesign.moviesapp.common.data.model.exception

import com.hyperdesign.moviesapp.common.domain.model.exception.IErrorKeyEnum
import com.hyperdesign.moviesapp.common.domain.model.exception.RequestErrorKeyValues

sealed class MoviesException(message: String?) : Exception(message) {
    sealed class Network(override val message: String? = null) : MoviesException(message) {
        data class Repeatable(override val message: String? = null) : Network(message)
        data class Unhandled(val errorCode: Int, override val message: String? = null) :
            Network(message = "Network Unhandled error with code:${errorCode}, and the failure reason: $message")
    }

    sealed class Client(override val message: String?) : MoviesException(message) {
        data object UnAuthorized : Client(message = "Unauthorized")
        data class ResponseValidation(
            val errors: Map<IErrorKeyEnum, String>,
            override val message: String? = null
        ) : Client(message)

        data class Unhandled(val errorCode: Int, override val message: String? = null) :
            Client(message = "Client Unhandled error with code:${errorCode}, and the failure reason: $message")
    }

    sealed class Server(message: String?) : MoviesException(message) {
        data class InternalServerError(
            override val message: String? = null,
            val httpErrorCode: Int
        ) : Server(message = "Internal server error with code:${httpErrorCode}, and the failure reason: $message")
    }

    sealed class Local(message: String?) : MoviesException(message) {
        data class RequestValidation(
            override val message: String? = null,
            val errors: Map<IErrorKeyEnum, RequestErrorKeyValues> = hashMapOf(),
        ) : Local(message)

        data class IOOperation(override val message: String? = null) :
            Local(message)

        data class Unhandled(val errorCode: Int, override val message: String? = null) :
            Local(message = "Local Unhandled error with code:${errorCode}, and the failure reason: $message")
    }

    data class UnKnown(override val message: String? = null) : MoviesException(message)
}