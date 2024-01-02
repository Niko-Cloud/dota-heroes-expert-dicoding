package com.dicoding.dotaheroesbase.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dicoding.dotaheroesbase.core.data.source.local.entity.HeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {
    @Query("SELECT * FROM hero")
    fun getAllHero(): Flow<List<HeroEntity>>

    @Query("SELECT * FROM hero where is_bookmark = 1")
    fun getBookmarkHero(): Flow<List<HeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(heroList: List<HeroEntity>)

    @Update
    fun updateBookmarkHero(hero: HeroEntity)
}
