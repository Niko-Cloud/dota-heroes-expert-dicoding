package com.dicoding.dotaheroesbase.core.domain.usecase

import com.dicoding.dotaheroesbase.core.domain.model.Hero
import com.dicoding.dotaheroesbase.core.domain.repository.IHeroRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HeroInteractor @Inject constructor(private val heroRepository: IHeroRepository) : HeroUseCase{
    override fun getAllHeroes() = heroRepository.getAllHeroes()

    override fun getBookmarkHeroes() = heroRepository.getBookmarkHero()

    override fun setBookmarkHero(hero: Hero, state: Boolean) {
        return heroRepository.setBookmarkHero(hero, state)
    }

}