package com.cagataymuhammet.itunesapi.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cagataymuhammet.itunesapi.util.SingleLiveEvent


abstract class BaseViewModel : ViewModel() {
    var isLoading = SingleLiveEvent<Boolean>()
    var exceptionLiveData = SingleLiveEvent<Exception>()
    var isPageLoaded = MutableLiveData<Boolean>(false)
}