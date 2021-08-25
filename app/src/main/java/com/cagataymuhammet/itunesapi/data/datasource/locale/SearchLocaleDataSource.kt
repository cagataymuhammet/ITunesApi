package com.cagataymuhammet.itunesapi.data.datasource.locale

import com.cagataymuhammet.itunesapi.util.networking.ITunesService
import com.cagataymuhammet.itunesapi.data.model.SearchResponse
import com.cagataymuhammet.itunesapi.util.constants.Resource
import com.medipol.medipolhafat11mvvm.data.datasource.SearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchLocaleDataSource   : SearchDataSource {

    override suspend fun doSearch(term: String,entity: String?): Flow<Resource<SearchResponse>> = flow {

        //Locale provider
    }
}