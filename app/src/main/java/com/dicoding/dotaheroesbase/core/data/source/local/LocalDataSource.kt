package com.dicoding.dotaheroesbase.core.data.source.local

import com.dicoding.dotaheroesbase.core.data.source.local.entity.HeroEntity
import com.dicoding.dotaheroesbase.core.data.source.local.room.HeroDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val heroDao: HeroDao){
    fun getAllHero(): Flow<List<HeroEntity>> = heroDao.getAllHero()

    fun getBookmarkHero(): Flow<List<HeroEntity>> = heroDao.getBookmarkHero()

    suspend fun insertHero(heroList: List<HeroEntity>) = heroDao.insertHero(heroList)

    fun setBookmarkHero(hero: HeroEntity, newState: Boolean){
        hero.isBookmark = newState
        heroDao.updateBookmarkHero(hero)
    }
}