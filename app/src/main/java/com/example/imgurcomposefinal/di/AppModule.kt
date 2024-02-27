package com.example.imgurcomposefinal.di

import android.app.Application
import androidx.room.Room
import com.example.imgurcomposefinal.data.local.ImgurDatabase
import com.example.imgurcomposefinal.data.remote.ImgurApi
import com.example.imgurcomposefinal.data.remote.ImgurApi.Companion.BASE_URL
import com.example.imgurcomposefinal.data.repository.ImgurRepositoryImpl
import com.example.imgurcomposefinal.data.util.Converters
import com.example.imgurcomposefinal.data.util.GsonParser
import com.example.imgurcomposefinal.domain.ImgurRepository
import com.example.imgurcomposefinal.domain.usecase.GetImg
import com.example.imgurcomposefinal.util.MyInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    // App needs Authorization: Client-ID via Header
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val loggingClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(MyInterceptor())
            .build()

    @Singleton
    @Provides
    fun provideImgurApi() : ImgurApi =


        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(loggingClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImgurApi::class.java)



    @Provides
    @Singleton
    fun provideUseCase(repository: ImgurRepository): GetImg {
        return GetImg(repository)
    }

    @Singleton
    @Provides
    fun provideMainRepository(api: ImgurApi, db: ImgurDatabase): ImgurRepository = ImgurRepositoryImpl(api, db.imgurDao)

    @Provides
    @Singleton
    fun provideDatabase(app:Application): ImgurDatabase {
        return Room.databaseBuilder(
            app,
            ImgurDatabase::class.java,
            "imgur_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .fallbackToDestructiveMigration()
            .build()
    }

}