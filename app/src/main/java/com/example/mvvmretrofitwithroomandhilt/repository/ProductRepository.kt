package com.example.mvvmretrofitwithroomandhilt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmretrofitwithroomandhilt.model.Product
import com.example.mvvmretrofitwithroomandhilt.model.Response
import com.example.mvvmretrofitwithroomandhilt.retrofitapi.ProductAPI
import com.example.mvvmretrofitwithroomandhilt.roomdb.ProductDatabase
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productAPI: ProductAPI,
                                            private val productDB: ProductDatabase) {

    private val productListLiveData = MutableLiveData<Response<List<Product>>>()

    val productLiveDataObj: LiveData<Response<List<Product>>>
        get() = productListLiveData

    suspend fun getProducts(){
        productListLiveData.postValue(Response.Loading())
        val result = productAPI.getProductList()

        if (result.isSuccessful && result.body() != null){
            try {
                productDB.productDao().insertProductData(result.body()?.toList()!!)
                productListLiveData.postValue(Response.Success(result.body()?.toList()!!))
            }catch (e: Exception){
                productListLiveData.postValue(Response.Error(result.message()))
            }
        }else{
            productListLiveData.postValue(Response.Error(result.message()))
        }

    }

}