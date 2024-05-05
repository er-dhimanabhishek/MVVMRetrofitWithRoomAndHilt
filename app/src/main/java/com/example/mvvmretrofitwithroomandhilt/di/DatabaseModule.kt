package com.example.mvvmretrofitwithroomandhilt.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmretrofitwithroomandhilt.roomdb.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDB(@ApplicationContext context: Context): ProductDatabase{
        return Room.databaseBuilder(context, ProductDatabase::class.java, "productdb").build()
    }

}