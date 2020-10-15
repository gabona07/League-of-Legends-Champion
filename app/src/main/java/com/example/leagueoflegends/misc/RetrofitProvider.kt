package com.example.leagueoflegends.misc

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    companion object {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://ddragon.leagueoflegends.com/cdn/10.21.1/data/en_US/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}


