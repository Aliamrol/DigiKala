package com.example.digikala.data.remote

sealed class NetworkResults<T>(
    val message: String? = null,
    val data: T? = null,
) {
    class Success<T>(message: String, data: T) : NetworkResults<T>(message, data)
    class Error<T>(message: String, data: T? = null) : NetworkResults<T>(message, data)
    class Loading<T> : NetworkResults<T>()
}