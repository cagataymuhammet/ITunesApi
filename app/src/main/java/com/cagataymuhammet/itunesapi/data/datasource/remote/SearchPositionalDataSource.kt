package com.cagataymuhammet.itunesapi.data.datasource.remote

import androidx.paging.PositionalDataSource


class SearchPositionalDataSource<T>(private val items: List<T>) : PositionalDataSource<T>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<T>) {
        callback.onResult(items, 0, items.size)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<T>) {
        val start = params.startPosition
        val end = params.startPosition + params.loadSize
        callback.onResult(items.subList(start, end))
    }
}

