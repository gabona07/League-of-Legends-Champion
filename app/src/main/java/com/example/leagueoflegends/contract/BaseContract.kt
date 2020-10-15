package com.example.leagueoflegends.contract

import java.lang.Exception

interface BaseContract {

    interface BaseView {
        fun onError(exception: Exception)
    }

    interface BasePresenter {
        fun onAttach(view: BaseView)
        fun onDetach()
    }
}