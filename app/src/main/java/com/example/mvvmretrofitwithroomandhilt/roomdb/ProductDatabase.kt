package com.example.mvvmretrofitwithroomandhilt.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmretrofitwithroomandhilt.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

}