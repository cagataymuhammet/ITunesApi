package com.cagataymuhammet.itunesapi.di

import android.content.Context
import com.cagataymuhammet.itunesapi.ui.search.search.SearchPaggedListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideSearchPaggedListAdapter(@ApplicationContext appContext: Context): SearchPaggedListAdapter {
        return SearchPaggedListAdapter(appContext)
    }
}