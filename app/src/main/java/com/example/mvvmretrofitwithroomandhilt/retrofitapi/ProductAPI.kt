package com.example.mvvmretrofitwithroomandhilt.retrofitapi

import com.example.mvvmretrofitwithroomandhilt.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {

    @GET("products")
    suspend fun getProductList() : Response<List<Product>>

}