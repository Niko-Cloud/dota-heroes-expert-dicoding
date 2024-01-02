package com.dicoding.dotaheroesbase.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(heroUseCase: HeroUseCase) : ViewModel() {
    val hero = heroUseCase.getAllHeroes().asLiveData()
}
