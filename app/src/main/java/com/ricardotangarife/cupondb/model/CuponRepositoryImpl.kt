package com.ricardotangarife.cupondb.model

import android.util.Log
import com.ricardotangarife.cupondb.presenter.CuponPresenter
import com.ricardotangarife.cupondb.view.CuponsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuponRepositoryImpl(var cuponPresenter: CuponPresenter): CuponRepository {

    override fun loadListCupons() {
        val apiKey= "a96a81da79b6948422c551b931576479"
        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<cupons> {
                override fun onFailure(call: Call<cupons>, t: Throwable) {
                    cuponPresenter.showErrorLoadCupons(t.message)
                }
                override fun onResponse(call: Call<cupons>, response: Response<cupons>) {
                    if (response.isSuccessful) {
                        cuponPresenter.sendListCupons(response.body()?.offers)
                    }
                }
            })
    }

}