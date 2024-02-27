package com.example.imgurcomposefinal.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.imgurcomposefinal.data.remote.dto.Data

@Entity
data class ImgurEntity(
    val data: List<Data>,
    @PrimaryKey val id: Int? = null
)
