package com.dicoding.dotaheroesbase.ui.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(heroUseCase: HeroUseCase) : ViewModel() {
    val bookmark = heroUseCase.getBookmarkHeroes().asLiveData()
}