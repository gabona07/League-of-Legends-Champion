package com.example.leagueoflegends.presenter

import com.example.leagueoflegends.contract.BaseContract
import com.example.leagueoflegends.misc.ApiService
import com.example.leagueoflegends.misc.RetrofitProvider
import com.example.leagueoflegends.model.Response
import io.reactivex.Single

class MainActivityPresenter: BaseContract.BasePresenter {
    private var view: BaseContract.BaseView? = null
    private val retrofit = RetrofitProvider.retrofit

    override fun onAttach(view: BaseContract.BaseView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun getChampions(): Single<Response> {
        return retrofit.create(ApiService::class.java).getChampions()
    }

}