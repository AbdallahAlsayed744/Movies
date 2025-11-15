package com.hyperdesign.moviesapp.features.home.di

import com.hyperdesign.moviesapp.features.home.data.repo.HomeRepo
import com.hyperdesign.moviesapp.features.home.data.repo.remote.HomeApiService
import com.hyperdesign.moviesapp.features.home.domain.repo.IHomeRepo
import com.hyperdesign.moviesapp.features.home.domain.repo.remote.IHomeApiService
import com.hyperdesign.moviesapp.features.home.domain.usecase.GetMoviesUseCase
import com.hyperdesign.moviesapp.features.home.ui.viewmodel.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val HomeModule = module {


    factoryOf(::HomeApiService) bind IHomeApiService::class
    factoryOf(::HomeRepo) bind IHomeRepo::class

    factoryOf(::GetMoviesUseCase)

    viewModelOf(::HomeViewModel)


}