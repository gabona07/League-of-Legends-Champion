package com.example.leagueoflegends.contract

import com.example.leagueoflegends.model.Response
import io.reactivex.Single
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