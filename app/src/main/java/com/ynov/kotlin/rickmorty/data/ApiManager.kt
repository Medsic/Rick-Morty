package com.ynov.kotlin.rickmorty.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import rx.Single

private const val API_BASE_URL = "https://rickandmortyapi.com/api/"

class ApiManager {

    private val service: ApiService

    interface ApiService {
        @GET("/things")
        fun retrieveThings(): Single<Things>
    }

    init {
        service = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}