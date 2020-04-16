package com.ricardotangarife.cupondb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ricardotangarife.cupondb.R
import com.ricardotangarife.cupondb.model.ApiService
import com.ricardotangarife.cupondb.model.Offer
import com.ricardotangarife.cupondb.model.cupons
import com.ricardotangarife.cupondb.presenter.CuponPresenter
import com.ricardotangarife.cupondb.presenter.CuponPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CuponView {

    private var cuponPresenter: CuponPresenter?= null
    private lateinit var root: View
    private var listCupons: List<Offer> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )

        cuponPresenter = CuponPresenterImpl(this)

        getCupons()
    }

    fun getCupons(){
        cuponPresenter?.loadListCupons()
    }

    override fun showErrorLoadCupons(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showListCupons(cupons: List<Offer>?) {
        this.listCupons = cupons
        this.recyclerView.layoutManager = LinearLayoutManager(
            this.applicationContext,
            RecyclerView.VERTICAL,
            false)
        val cuponsAdapter = CuponsAdapter(listCupons as ArrayList<Offer>)
        this.recyclerView.adapter = cuponsAdapter
    }

}
