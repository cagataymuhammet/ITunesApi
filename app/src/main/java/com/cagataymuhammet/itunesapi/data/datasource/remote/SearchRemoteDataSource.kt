package com.cagataymuhammet.itunesapi.data.datasource.remote

import com.cagataymuhammet.itunesapi.util.networking.ITunesService
import com.cagataymuhammet.itunesapi.data.model.SearchResponse
import com.cagataymuhammet.itunesapi.util.constants.Resource
import com.medipol.medipolhafat11mvvm.data.datasource.SearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query
import javax.inject.Inject

class SearchRemoteDataSource @Inject constructor(var service: ITunesService)  : SearchDataSource {


    override suspend fun doSearch(term: String,entity: String?): Flow<Resource<SearchResponse>> = flow {

        emit(Resource.Loading(true))
        try {
            emit(Resource.Success(service.doSearch(term,entity)))
        }
        catch (ex:Exception) {
            emit(Resource.Error(ex))
        }
    }
}