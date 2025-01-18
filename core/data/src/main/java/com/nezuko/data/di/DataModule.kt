package com.nezuko.data.di

import com.nezuko.data.repository.BinSearchImpl
import com.nezuko.data.source.remote.rapid.RapidApiSource
import com.nezuko.domain.repository.BinSearch
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

    companion object {
        @Provides
        @Singleton
        fun rapidApiSource(httpClient: HttpClient) = RapidApiSource(httpClient)
    }
}