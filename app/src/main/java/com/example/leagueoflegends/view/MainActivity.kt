package com.example.leagueoflegends.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.leagueoflegends.R
import com.example.leagueoflegends.contract.BaseContract
import org.koin.android.ext.android.inject
import java.lang.Exception

class MainActivity : AppCompatActivity(), BaseContract.BaseView {

    private val presenter: BaseContract.BasePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onError(exception: Exception) {
        Toast.makeText(this, "${exception.message}", Toast.LENGTH_SHORT).show()
    }
}