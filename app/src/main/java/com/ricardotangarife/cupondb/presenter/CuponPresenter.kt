package com.ricardotangarife.cupondb.presenter

import com.ricardotangarife.cupondb.model.Offer

interface CuponPresenter {
    fun loadListCupons()
    fun showErrorLoadCupons(message: String?)
    fun sendListCupons(cupons: List<Offer>?)
}