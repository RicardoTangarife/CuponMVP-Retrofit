package com.ricardotangarife.cupondb.view

import com.ricardotangarife.cupondb.model.Offer

interface CuponView {
    fun showErrorLoadCupons(message: String?)
    fun showListCupons(cupons: List<Offer>?)
}