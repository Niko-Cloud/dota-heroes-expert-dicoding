package com.dicoding.dotaheroesbase.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.dotaheroesbase.core.data.source.local.room.HeroDao
import com.dicoding.dotaheroesbase.core.data.source.local.room.HeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.zetetic.database.sqlcipher.SQLiteConnection
import net.zetetic.database.sqlcipher.SQLiteDatabaseHook
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HeroDatabase {
        System.loadLibrary("sqlcipher")
        val passphrase: ByteArray =
            "dicoding".encodeToByteArray()
        val factory = SupportOpenHelperFactory(passphrase, object : SQLiteDatabaseHook {
            override fun preKey(connection: SQLiteConnection) = Unit

            override fun postKey(connection: SQLiteConnection) {
                connection.execute(
                    "PRAGMA cipher_memory_security = ON", null, null
                )
            }
        },false)

            return Room.databaseBuilder(
                context,
                HeroDatabase::
                class.java,
                "DotaHeroes.db"
            ).fallbackToDestructiveMigration()
                .openHelperFactory(factory)
                .build()
    }

    @Provides
    fun provideHeroDao(database: HeroDatabase): HeroDao = database.heroDao()
}
