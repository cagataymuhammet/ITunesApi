package com.cagataymuhammet.itunesapi.util.networking

import com.cagataymuhammet.itunesapi.data.model.SearchResponse
import com.cagataymuhammet.itunesapi.util.constants.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ITunesService {




    //https://itunes.apple.com/search?term=orhan&entity=
    @GET("search")
    suspend fun doSearch(@Query("term") term:String,
                         @Query("entity") entity:String?): SearchResponse


}