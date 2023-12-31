package com.dicoding.dotaheroesbase.core.domain.usecase

import com.dicoding.dotaheroesbase.core.data.Resource
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface HeroUseCase {
    fun getAllHeroes(): Flow<Resource<List<Hero>>>
    fun getBookmarkHeroes(): Flow<List<Hero>>
    fun setBookmarkHero(hero: Hero, state: Boolean)
}
