package com.example.mvvmretrofitwithroomandhilt.model

sealed class Response<T>(val productList: T? = null, val errorMsg: String? = null){

    class Loading<T>(): Response<T>()

    class Success<T>(prodList: T? = null): Response<T>(productList = prodList)

    class Error<T>(error: String? = null): Response<T>(errorMsg = error)

}
