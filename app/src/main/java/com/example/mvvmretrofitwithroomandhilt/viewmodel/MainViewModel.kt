package com.example.mvvmretrofitwithroomandhilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmretrofitwithroomandhilt.model.Product
import com.example.mvvmretrofitwithroomandhilt.model.Response
import com.example.mvvmretrofitwithroomandhilt.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository): ViewModel() {
    val productsLiveData: LiveData<Response<List<Product>>>
    get() = repository.productLiveDataObj
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts()
        }
    }

}