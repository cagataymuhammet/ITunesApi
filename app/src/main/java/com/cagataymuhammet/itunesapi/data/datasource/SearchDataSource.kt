package com.medipol.medipolhafat11mvvm.data.datasource


import com.cagataymuhammet.itunesapi.data.model.SearchResponse
import com.cagataymuhammet.itunesapi.util.constants.Resource
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {

    suspend fun doSearch(term: String,entity: String?): Flow<Resource<SearchResponse>>
}