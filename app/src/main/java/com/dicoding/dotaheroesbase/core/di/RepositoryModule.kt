package com.dicoding.dotaheroesbase.core.di

import com.dicoding.dotaheroesbase.core.data.HeroRepository
import com.dicoding.dotaheroesbase.core.domain.repository.IHeroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(heroRepository: HeroRepository): IHeroRepository
}