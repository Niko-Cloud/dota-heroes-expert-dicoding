package com.dicoding.dotaheroesbase.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.dotaheroesbase.core.data.source.local.room.HeroDao
import com.dicoding.dotaheroesbase.core.data.source.local.room.HeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):HeroDatabase = Room.databaseBuilder(
        context,
        HeroDatabase::class.java, "Hero.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideHeroDao(database: HeroDatabase):HeroDao = database.heroDao()
}