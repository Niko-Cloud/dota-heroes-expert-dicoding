package com.dicoding.dotaheroesbase.bookmark

import android.content.Context
import com.dicoding.dotaheroesbase.di.BookmarkModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [BookmarkModuleDependencies::class])
interface BookmarkComponent {
    fun inject(fragment: BookmarkFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: BookmarkModuleDependencies): Builder
        fun build(): BookmarkComponent
    }
}
