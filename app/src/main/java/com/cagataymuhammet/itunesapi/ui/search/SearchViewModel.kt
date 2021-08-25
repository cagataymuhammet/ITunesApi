package com.cagataymuhammet.itunesapi.ui.search


import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.cagataymuhammet.itunesapi.data.model.SearchResult
import com.cagataymuhammet.itunesapi.data.datasource.remote.SearchPositionalDataSource
import com.cagataymuhammet.itunesapi.ui.base.BaseViewModel
import com.cagataymuhammet.itunesapi.util.UiThreadExecutor
import com.cagataymuhammet.itunesapi.util.constants.Constants
import com.cagataymuhammet.itunesapi.util.constants.Resource
import com.medipol.medipolhafat11mvvm.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository) : BaseViewModel() {

    var searchResponseLiveData = MutableLiveData<PagedList<SearchResult>>()

    fun doSearch(term: String,entity: String?) {

        viewModelScope.launch {

                repository.doSearch(term,entity).collect {

                    when (it) {

                        is Resource.Loading -> {
                            isPageLoaded.postValue(false)
                            isLoading.postValue(true)
                        }

                        is Resource.Error -> {
                            isLoading.postValue(false)
                            exceptionLiveData.postValue(it.apiException)
                        }

                        is Resource.Success -> {

                            isLoading.postValue(false)
                            isPageLoaded.postValue(true)

                            it.data.let {

                                val pagedListConfig = PagedList.Config.Builder()
                                        .setPageSize(Constants.PAGE_SIZE)
                                        .build()

                                val pagedList = PagedList.Builder(SearchPositionalDataSource(it.results),pagedListConfig)
                                        .setNotifyExecutor (UiThreadExecutor ())
                                        .setFetchExecutor (AsyncTask.THREAD_POOL_EXECUTOR)
                                        .build ()

                                searchResponseLiveData.postValue(pagedList)

                            }
                        }
                    }
                }
        }
    }
}

