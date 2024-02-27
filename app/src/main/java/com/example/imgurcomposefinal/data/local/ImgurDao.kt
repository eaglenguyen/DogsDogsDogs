package com.example.imgurcomposefinal.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImgurDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(imgurEntity: ImgurEntity)

    @Query("SELECT * from imgurentity")
    suspend fun getImgur(): ImgurEntity

    @Query("DELETE FROM imgurentity")
    suspend fun deleteLocalCache()
}