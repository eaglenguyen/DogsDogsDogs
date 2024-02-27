package com.example.imgurcomposefinal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.imgurcomposefinal.data.util.Converters


@Database(entities = [ImgurEntity::class], version = 1)

@TypeConverters(Converters::class)
abstract class ImgurDatabase: RoomDatabase() {

    abstract val imgurDao: ImgurDao


}