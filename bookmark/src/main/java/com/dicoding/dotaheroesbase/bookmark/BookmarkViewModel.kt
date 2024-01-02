package com.dicoding.dotaheroesbase.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.dotaheroesbase.core.domain.usecase.HeroUseCase

class BookmarkViewModel(heroUseCase: HeroUseCase) : ViewModel() {
    val bookmark = heroUseCase.getBookmarkHeroes().asLiveData()
}
