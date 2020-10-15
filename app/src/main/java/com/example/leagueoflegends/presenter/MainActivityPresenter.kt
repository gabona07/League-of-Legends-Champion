package com.example.leagueoflegends.presenter

import com.example.leagueoflegends.contract.BaseContract

class MainActivityPresenter: BaseContract.BasePresenter {
    private var view: BaseContract.BaseView? = null

    override fun onAttach(view: BaseContract.BaseView) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

}