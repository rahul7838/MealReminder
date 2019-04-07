package com.example.dietplan.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceApiRepository  {

    fun getRetofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://104.196.113.9/dummy/")
            .client(OkHttpProvider().provide())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}