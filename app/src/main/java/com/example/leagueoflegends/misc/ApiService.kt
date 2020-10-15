package com.example.leagueoflegends.misc

import com.example.leagueoflegends.model.Response
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("champion.json")
    fun getChampions(): Single<Response>
}