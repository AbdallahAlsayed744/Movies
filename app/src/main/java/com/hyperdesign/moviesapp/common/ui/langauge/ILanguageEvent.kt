package com.hyperdesign.moviesapp.common.ui.langauge

sealed interface ILanguageEvent {
    val languageCode : String
    data class ChangeLanguage(override val languageCode: String) : ILanguageEvent
}