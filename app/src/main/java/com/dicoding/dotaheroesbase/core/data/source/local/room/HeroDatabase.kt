package com.dicoding.dotaheroesbase.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dicoding.dotaheroesbase.core.data.source.local.entity.HeroEntity
import com.dicoding.dotaheroesbase.core.utils.TypeConverter

@Database(entities = [HeroEntity::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class HeroDatabase:RoomDatabase() {
    abstract fun heroDao(): HeroDao
}