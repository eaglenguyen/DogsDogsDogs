package com.example.imgurcomposefinal.domain

import com.example.imgurcomposefinal.data.remote.dto.Data
import com.example.imgurcomposefinal.data.remote.dto.FirstData
import com.example.imgurcomposefinal.util.Resource
import kotlinx.coroutines.flow.Flow

interface ImgurRepository {
    fun getGallery(): Flow<Resource<FirstData>>
}