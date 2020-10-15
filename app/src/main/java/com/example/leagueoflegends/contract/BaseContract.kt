package com.example.leagueoflegends.contract

import com.example.leagueoflegends.model.Response
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import java.lang.Exception

interface BaseContract {

    interface BaseView {
        fun onError(exception: Exception)
    }

    interface BasePresenter {
        fun onAttach(view: BaseView)
        fun onDetach()
        fun getChampions(): Single<Response>
    }
}