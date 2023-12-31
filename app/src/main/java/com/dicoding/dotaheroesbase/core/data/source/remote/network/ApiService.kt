package com.dicoding.dotaheroesbase.core.data.source.remote.network

import com.dicoding.dotaheroesbase.core.data.source.remote.response.HeroResponse
import com.dicoding.dotaheroesbase.core.data.source.remote.response.HeroResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("heroStats")
    suspend fun getHeroes(): HeroResponseItem
}