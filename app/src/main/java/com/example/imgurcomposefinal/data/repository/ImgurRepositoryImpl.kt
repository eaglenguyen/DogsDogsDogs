package com.example.imgurcomposefinal.data.repository

import com.example.imgurcomposefinal.data.local.ImgurDao
import com.example.imgurcomposefinal.data.mapper.FirstData
import com.example.imgurcomposefinal.data.mapper.toImgurEntity
import com.example.imgurcomposefinal.data.remote.ImgurApi
import com.example.imgurcomposefinal.data.remote.dto.Data
import com.example.imgurcomposefinal.data.remote.dto.FirstData
import com.example.imgurcomposefinal.domain.ImgurRepository
import com.example.imgurcomposefinal.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImgurRepositoryImpl @Inject constructor(
    private val api: ImgurApi,
    private val dao: ImgurDao
) : ImgurRepository {
    override fun getGallery(): Flow<Resource<FirstData>> = flow {
        emit(Resource.Loading())

        try {
            val fetchApi = api.getGallery()

            dao.deleteLocalCache()
            dao.insert(fetchApi.toImgurEntity())

        } catch (e: HttpException) {
        emit(Resource.Error(message = "Something went wrong!"))
    } catch (e: IOException) {
        emit(Resource.Error(message = "Could not reach server"))
    }
        val localCache = dao.getImgur()
        emit(Resource.Success(localCache.FirstData()))
    }

}