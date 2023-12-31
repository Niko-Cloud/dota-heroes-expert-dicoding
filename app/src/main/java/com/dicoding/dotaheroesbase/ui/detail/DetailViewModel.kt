package com.dicoding.dotaheroesbase.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.dotaheroesbase.core.domain.model.Hero
import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val heroUseCase: HeroUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Hero, newStatus: Boolean) =
        heroUseCase.setBookmarkHero(tourism, newStatus)
}