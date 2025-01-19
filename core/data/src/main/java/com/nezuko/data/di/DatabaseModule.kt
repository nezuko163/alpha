package com.nezuko.data.di

import android.content.Context
import androidx.room.Room
import com.nezuko.data.source.local.AppDatabase
import com.nezuko.data.source.local.BinDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideBinDao(database: AppDatabase): BinDao {
        return database.binDao()
    }
}