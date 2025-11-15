package com.hyperdesign.moviesapp.common.di

import com.hyperdesign.moviesapp.common.data.repo.remote.ApiService
import com.hyperdesign.moviesapp.common.data.repo.remote.RemoteDataSourceProvider
import com.hyperdesign.moviesapp.common.data.repo.remote.provideHttpClient
import com.hyperdesign.moviesapp.common.domain.repo.remote.IRemoteDataSourceProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<ApiService> { ApiService(provideHttpClient(get())) }
    singleOf(::RemoteDataSourceProvider) bind IRemoteDataSourceProvider::class

}