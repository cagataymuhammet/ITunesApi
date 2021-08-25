package com.medipol.medipolhafat11mvvm.data.repository


import com.cagataymuhammet.itunesapi.data.model.SearchResponse
import com.cagataymuhammet.itunesapi.util.constants.Resource
import com.medipol.medipolhafat11mvvm.data.datasource.SearchDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(private val dataSource:SearchDataSource) : SearchDataSource{

     override  suspend fun doSearch(term: String,entity: String?): Flow<Resource<SearchResponse>> = dataSource.doSearch(term,entity)

}

