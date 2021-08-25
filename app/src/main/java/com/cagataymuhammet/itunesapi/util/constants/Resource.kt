package com.cagataymuhammet.itunesapi.util.constants

import java.lang.Exception


sealed class Resource<out T> {
    data class Loading(val loading: Boolean) : Resource<Nothing>()
    data class Error(val apiException: Exception) : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
}