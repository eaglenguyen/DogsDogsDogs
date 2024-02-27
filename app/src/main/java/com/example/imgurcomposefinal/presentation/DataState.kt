package com.example.imgurcomposefinal.presentation

import com.example.imgurcomposefinal.data.remote.dto.Data
import com.example.imgurcomposefinal.data.remote.dto.Image

data class DataState (
    val imgList: List<Data> = emptyList(),
    val isLoading: Boolean = false
)