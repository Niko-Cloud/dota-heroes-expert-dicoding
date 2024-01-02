package com.dicoding.dotaheroesbase.di

import com.dicoding.dotaheroesbase.core.domain.usecase.HeroInteractor
import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideHeroUseCase(heroInteractor: HeroInteractor): HeroUseCase
}
