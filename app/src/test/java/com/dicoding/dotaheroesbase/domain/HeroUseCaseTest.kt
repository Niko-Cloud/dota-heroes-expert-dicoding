package com.dicoding.dotaheroesbase.domain

import com.dicoding.dotaheroesbase.core.data.Resource
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HeroUseCaseTest {
    @Mock
    lateinit var mockHeroUseCase: HeroUseCase

    @Mock
    lateinit var mockHero: Hero

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `should have getting all heroes`() = runBlocking {
        val flowHeroes = flow { emit(Resource.Success(listOf(mockHero) )) }

        `when`(mockHeroUseCase.getAllHeroes()).thenReturn(flowHeroes)

        val result = mockHeroUseCase.getAllHeroes().toList()

        assertEquals(listOf(mockHero), result.first().data)
    }

    @Test
    fun `should have getting bookmarked heroes`() = runBlocking {
        `when`(mockHeroUseCase.getBookmarkHeroes()).thenReturn(flow { emit(listOf(mockHero)) })

        val result = mockHeroUseCase.getBookmarkHeroes().toList()

        assertEquals(listOf(mockHero), result.first())
    }
}