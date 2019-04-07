package com.example.dietplan.data

import com.example.dietplan.BuildConfig
import okhttp3.OkHttpClient

class OkHttpProvider {
        lateinit var builder : OkHttpClient.Builder
    fun provide() : OkHttpClient {
        builder = OkHttpClient.Builder()

        if(BuildConfig.FLAVOR == "Mock") {
            builder.addInterceptor(MockInterceptor())
        }

        return builder.build()
    }
}
