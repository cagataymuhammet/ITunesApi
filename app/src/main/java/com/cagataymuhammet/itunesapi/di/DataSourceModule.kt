package com.turkcell.digitalBrand.module

import com.medipol.medipolhafat11mvvm.data.datasource.SearchDataSource
import com.cagataymuhammet.itunesapi.data.datasource.remote.SearchRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindSearchDataSource(
        dataSource: SearchRemoteDataSource
    ): SearchDataSource

}