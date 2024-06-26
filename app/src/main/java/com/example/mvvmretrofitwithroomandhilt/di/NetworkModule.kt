package com.example.mvvmretrofitwithroomandhilt.di

import com.example.mvvmretrofitwithroomandhilt.constants.Constants
import com.example.mvvmretrofitwithroomandhilt.retrofitapi.ProductAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesProductAPI(retrofit: Retrofit): ProductAPI{
        return retrofit.create(ProductAPI::class.java)
    }

}