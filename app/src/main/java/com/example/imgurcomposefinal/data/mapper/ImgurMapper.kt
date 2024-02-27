package com.example.imgurcomposefinal.data.mapper

import com.example.imgurcomposefinal.data.local.ImgurEntity
import com.example.imgurcomposefinal.data.remote.dto.FirstData

fun FirstData.toImgurEntity(): ImgurEntity {
    return ImgurEntity(
        data = data
    )
}

fun ImgurEntity.FirstData(): FirstData {
    return FirstData(
        data = data
    )
}