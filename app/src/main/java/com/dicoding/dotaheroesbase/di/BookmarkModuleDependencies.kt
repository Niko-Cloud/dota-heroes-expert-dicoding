package com.dicoding.dotaheroesbase.di

import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface BookmarkModuleDependencies {
    fun heroUseCase(): HeroUseCase
}