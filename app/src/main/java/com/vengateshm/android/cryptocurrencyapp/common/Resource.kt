package com.vengateshm.android.cryptocurrencyapp.common

sealed class Resource<T>(val mData: T? = null, val mMessage: String? = null) {
    data class Success<T>(val data: T) : Resource<T>(data)
    data class Error<T>(val message: String, val data: T? = null) : Resource<T>(data, message)
    data class Loading<T>(val data: T? = null) : Resource<T>(data)
}
