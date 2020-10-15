package com.example.leagueoflegends.view

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.leagueoflegends.R
import com.example.leagueoflegends.contract.BaseContract
import com.example.leagueoflegends.misc.MainAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import java.lang.Exception

class MainActivity : AppCompatActivity(), BaseContract.BaseView {

    private val presenter: BaseContract.BasePresenter by inject()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        displayChampions()
    }

    @SuppressLint("CheckResult")
    private fun displayChampions() {
        val adapter = MainAdapter()
        presenter.getChampions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                data -> adapter.setChampions(data.data.values.toTypedArray())
            },
                {error -> onError(error as Exception)})
        main_rec_view.adapter = adapter
    }

    override fun onError(exception: Exception) {
        Toast.makeText(this, "${exception.message}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}