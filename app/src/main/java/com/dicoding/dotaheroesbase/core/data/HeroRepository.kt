package com.dicoding.dotaheroesbase.core.data

import com.dicoding.dotaheroesbase.core.data.source.local.LocalDataSource
import com.dicoding.dotaheroesbase.core.data.source.remote.RemoteDataSource
import com.dicoding.dotaheroesbase.core.data.source.remote.response.HeroResponseItem
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import com.dicoding.dotaheroesbase.core.domain.repository.IHeroRepository
import com.dicoding.dotaheroesbase.core.utils.AppExecutors
import com.dicoding.dotaheroesbase.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IHeroRepository {
    override fun getAllHeroes(): Flow<Resource<List<Hero>>> =
        object : NetworkBoundResource<List<Hero>, List<HeroResponseItem>>() {
            override fun loadFromDB(): Flow<List<Hero>> {
                return localDataSource.getAllHero().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Hero>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<List<HeroResponseItem>> =
                remoteDataSource.getAllHeroes()

            override suspend fun saveCallResult(data: List<HeroResponseItem>) {
                val heroList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertHero(heroList)
            }
        }.asFlow()

    override fun getBookmarkHero(): Flow<List<Hero>> {
        return localDataSource.getBookmarkHero().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setBookmarkHero(hero: Hero, state: Boolean) {
        val heroEntity = DataMapper.mapDomainToEntity(hero)
        appExecutors.diskIO().execute { localDataSource.setBookmarkHero(heroEntity, state) }
    }

}