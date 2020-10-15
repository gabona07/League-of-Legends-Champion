package com.example.leagueoflegends

import com.example.leagueoflegends.contract.BaseContract
import com.example.leagueoflegends.presenter.MainActivityPresenter
import org.koin.dsl.module

val appModule = module {
    single<BaseContract.BasePresenter> {MainActivityPresenter()}
}
