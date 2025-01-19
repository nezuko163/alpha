package com.nezuko.data.di

import com.nezuko.data.repository.BinSearchImpl
import com.nezuko.data.repository.LocalStoreRepositoryImpl
import com.nezuko.data.source.remote.rapid.RapidApiSource
import com.nezuko.domain.repository.BinSearch
import com.nezuko.domain.repository.LocalStoreRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun binSearch(impl: BinSearchImpl): BinSearch

    @Binds
    @Singleton
    fun localStoreRepository(impl: LocalStoreRepositoryImpl): LocalStoreRepository

    companion object {
        @Provides
        @Singleton
        fun rapidApiSource(httpClient: HttpClient) = RapidApiSource(httpClient)
    }
}