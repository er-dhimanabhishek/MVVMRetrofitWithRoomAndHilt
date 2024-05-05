package com.example.mvvmretrofitwithroomandhilt.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.mvvmretrofitwithroomandhilt.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertProductData(dataList: List<Product>)

    @Query("SELECT * FROM productlist")
    suspend fun getProductData(): List<Product>

}