package com.dicoding.dotaheroesbase.core.data.source.remote

import android.util.Log
import com.dicoding.dotaheroesbase.core.data.source.remote.network.ApiService
import com.dicoding.dotaheroesbase.core.data.source.remote.response.HeroResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllHeroes(): Flow<List<HeroResponseItem>> {
        return flow {
            try {
                val dataArray = apiService.getHeroes()
                emit(dataArray)
            } catch (e: Exception) {
                emit(emptyList())
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}