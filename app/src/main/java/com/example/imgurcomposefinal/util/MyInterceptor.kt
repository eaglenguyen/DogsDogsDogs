package com.example.imgurcomposefinal.util

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {

    // clientID = 4a9adaa1f86eb11
    // client secret = c4a93800f84902e98dac6590468e2411c83d141a

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Client-ID 4a9adaa1f86eb11")
            .build()
        return chain.proceed(request)
    }
}