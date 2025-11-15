package com.hyperdesign.moviesapp.common.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptionsBuilder
import com.hyperdesign.moviesapp.R
import com.hyperdesign.moviesapp.common.data.model.exception.MoviesException
import com.hyperdesign.moviesapp.common.domain.model.Resource
import com.hyperdesign.moviesapp.common.domain.model.exception.IErrorKeyEnum
import com.hyperdesign.moviesapp.common.ui.errorhandling.model.UIText
import com.hyperdesign.moviesapp.common.ui.eventcontroller.IEventController
import com.hyperdesign.moviesapp.common.ui.langauge.ILanguageEvent
import com.hyperdesign.moviesapp.common.ui.loading.ILoadingEvent
import com.hyperdesign.moviesapp.common.ui.messages.IMessageEvent
import com.hyperdesign.moviesapp.common.ui.navigation.HomeGraph
import com.hyperdesign.moviesapp.common.ui.navigation.IDestination
import com.hyperdesign.moviesapp.common.ui.navigation.INavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import kotlin.getValue

abstract class BaseViewModel<State, Action>(stateType: State) : ViewModel(), KoinComponent {
    private val _state = MutableStateFlow(stateType)
    val state = _state.asStateFlow()
    private val navigator: INavigator by inject()
    private val messageEvent: IEventController<IMessageEvent> by inject(named("MessageEvent"))
    private val loadingEvent: IEventController<ILoadingEvent> by inject(named("LoadingEvent"))
    private val languageEvent: IEventController<ILanguageEvent> by inject(named("LanguageEvent"))

    abstract fun onActionTrigger(action: Action)

    fun updateState(update: State.() -> State) {
        _state.update { it.update() }
    }

    fun fireLoading(loadingEventType: ILoadingEvent) = viewModelScope.launch { loadingEvent.emit(loadingEventType) }

    fun fireMessage(messageEventType: IMessageEvent) = viewModelScope.launch { messageEvent.emit(messageEventType) }

    fun fireNavigate(destination: IDestination, builder: NavOptionsBuilder.() -> Unit = {}) =
        viewModelScope.launch { navigator.navigate(destination, builder = builder) }

    suspend fun fireNavigateUp() {
        navigator.navigateUp()
    }

    fun fireLanguageEvent(language: String) {
        viewModelScope.launch {
            languageEvent.emit(ILanguageEvent.ChangeLanguage(language))
        }
    }

    fun <Result> Flow<Resource<Result>>.collectResource(
        onSuccess: suspend (Result) -> Unit = {},
        onFailure: suspend (MoviesException) -> Unit = {},
        onLoading: suspend (Boolean) -> Unit = {},
    ) = viewModelScope.launch {
        this@collectResource.collect { resource ->
            when (resource) {
                is Resource.Failure -> {
                    handleExceptions(resource.exception, ::onRequestValidation)
                    onFailure(resource.exception)
                }

                is Resource.Loading -> onLoading(resource.isLoading)
                is Resource.Success -> onSuccess(resource.model)
            }
        }
    }

    private fun handleExceptions(
        exception: MoviesException,
        onRequestValidation: (Map<IErrorKeyEnum, UIText>) -> Unit = {},
    ) {
        when (exception) {
//            is ALTashiratException.Client.ResponseValidation -> onRequestValidation(
//                exception.errors.mapValues { UIText.DynamicString(it.value) }
//            )
//
//            is ALTashiratException.Client.UnAuthorized -> fireNavigate(
//                destination = IAuthGraph.LoginButtonSheetDestination
//            )
//
//            is ALTashiratException.Client.Unhandled -> handleExceptionMessages(message = exception.message)
//
//            is ALTashiratException.Local.IOOperation -> handleExceptionMessages(message = exception.message)
//
//            is ALTashiratException.Local.RequestValidation -> onRequestValidation(
//                exception.errors
//                    .mapValues { requestErrorMap[it.value] ?: UIText.StringResource(R.string.unkown_error) }
//            )
//
//            is ALTashiratException.Local.Unhandled -> handleExceptionMessages(message = exception.message)
//
//            is ALTashiratException.Network.Repeatable -> handleExceptionMessages(message = exception.message)
//
//            is ALTashiratException.Network.Unhandled -> handleExceptionMessages(message = exception.message)
//
//            is ALTashiratException.Server.InternalServerError -> handleExceptionMessages(message = exception.message)
//
//            is ALTashiratException.UnKnown -> handleExceptionMessages(message = exception.message)
            is MoviesException.Client.ResponseValidation -> onRequestValidation(
                exception.errors.mapValues { UIText.DynamicString(it.value) }
            )

            is MoviesException.Client.UnAuthorized -> fireNavigate(
                destination = HomeGraph.HomeDestination
            )

            is MoviesException.Client.Unhandled -> handleExceptionMessages(message = exception.message)

            is MoviesException.Local.IOOperation -> handleExceptionMessages(message = exception.message)

            is MoviesException.Local.RequestValidation ->
            {
//                onRequestValidation(
//                    exception.errors
//                        .mapValues { requestErrorMap[it.value] ?: UIText.StringResource(R.string.unkown_error) }
//                )

            }

            is MoviesException.Local.Unhandled -> handleExceptionMessages(message = exception.message)

            is MoviesException.Network.Repeatable -> handleExceptionMessages(message = exception.message)

            is MoviesException.Network.Unhandled -> handleExceptionMessages(message = exception.message)

            is MoviesException.Server.InternalServerError -> handleExceptionMessages(message = exception.message)

            is MoviesException.UnKnown -> handleExceptionMessages(message = exception.message)
        }
    }

    open fun onRequestValidation(errors: Map<IErrorKeyEnum, UIText>) {}

    private fun handleExceptionMessages(message: String?) = fireMessage(
        messageEventType = IMessageEvent.Toast(
            message = message?.let { UIText.DynamicString(it) }
                ?: UIText.StringResource(R.string.something_wrong)
        )
    )

    companion object {
//        private val requestErrorMap = mapOf<RequestErrorKeyValues, UIText>(
//            RequestErrorKeyValues.PASSWORD_LENGTH_BETWEEN_8_15 to UIText.StringResource(R.string.password_length_between_8_15),
//            RequestErrorKeyValues.PHONE_NUMBER_BETWEEN_9_15 to UIText.StringResource(R.string.phone_number_between_9_15),
//            RequestErrorKeyValues.PHONE_COUNTRY_CODE_NOT_EMPTY to UIText.StringResource(R.string.phone_country_code_not_empty),
//            RequestErrorKeyValues.USER_FIRST_NAME_BETWEEN_3_15 to UIText.StringResource(R.string.user_first_name_between_3_15),
//            RequestErrorKeyValues.USER_LAST_NAME_BETWEEN_3_15 to UIText.StringResource(R.string.user_last_name_between_3_15),
//            RequestErrorKeyValues.USER_EMAIL_FORMAT to UIText.StringResource(R.string.user_email_format),
//            RequestErrorKeyValues.USER_MIDDLE_NAME_LESS_THAN_15 to UIText.StringResource(R.string.middle_name),
//            RequestErrorKeyValues.BIRTH_DATE_SHOULD_BE_LESS_THAN_13_YEARS to UIText.StringResource(R.string.invalid_birthdate_format),
//            RequestErrorKeyValues.IMAGE_MIME_JPG_JPEG_PNG_AND_MAX_SIZE_512KB to UIText.StringResource(R.string.image_type_and_size)
//        )
    }
}