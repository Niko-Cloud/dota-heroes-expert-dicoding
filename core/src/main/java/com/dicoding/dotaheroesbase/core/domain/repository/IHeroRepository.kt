package com.dicoding.dotaheroesbase.core.domain.repository

import com.dicoding.dotaheroesbase.core.data.Resource
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface IHeroRepository {
    fun getAllHeroes(): Flow<Resource<List<Hero>>>

    fun getBookmarkHero(): Flow<List<Hero>>

    fun setBookmarkHero(hero: Hero, state: Boolean)
}
