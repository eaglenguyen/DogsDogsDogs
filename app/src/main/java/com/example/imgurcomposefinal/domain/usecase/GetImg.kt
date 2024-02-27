package com.example.imgurcomposefinal.domain.usecase

import com.example.imgurcomposefinal.data.remote.dto.Data
import com.example.imgurcomposefinal.data.remote.dto.FirstData
import com.example.imgurcomposefinal.domain.ImgurRepository
import com.example.imgurcomposefinal.util.Resource
import kotlinx.coroutines.flow.Flow

class GetImg(
    private val repository: ImgurRepository
) {
    operator fun invoke(): Flow<Resource<FirstData>> {
        return repository.getGallery()
    }
}