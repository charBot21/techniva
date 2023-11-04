package com.carlostorres.technivamovieapp.data.network

import com.carlostorres.technivamovieapp.common.constants.ApiConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {
    val movieService: MovieService by lazy {
        Retrofit.Builder()
        .baseUrl(ApiConstants.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(MovieService::class.java)
    }
}