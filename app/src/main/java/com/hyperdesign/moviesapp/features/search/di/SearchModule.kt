package com.hyperdesign.moviesapp.features.search.di

import com.hyperdesign.moviesapp.features.search.data.repo.SearchRepo
import com.hyperdesign.moviesapp.features.search.data.repo.remote.SearchApiServices
import com.hyperdesign.moviesapp.features.search.domain.repo.ISearchRepo
import com.hyperdesign.moviesapp.features.search.domain.repo.remote.ISearchApiServices
import com.hyperdesign.moviesapp.features.search.domain.usecase.SearchByTiitleUseCase
import com.hyperdesign.moviesapp.features.search.ui.viewmodel.SearchScreenViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val searchModule = module {
    viewModelOf(::SearchScreenViewModel)
    factoryOf(::SearchApiServices) bind ISearchApiServices::class
    factoryOf(::SearchRepo) bind ISearchRepo::class
    factoryOf(::SearchByTiitleUseCase)
}