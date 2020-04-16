package com.ricardotangarife.cupondb.presenter

import com.ricardotangarife.cupondb.model.CuponInteractor
import com.ricardotangarife.cupondb.model.CuponInteractorImpl
import com.ricardotangarife.cupondb.model.Offer
import com.ricardotangarife.cupondb.view.CuponView

class CuponPresenterImpl(var cuponView: CuponView) : CuponPresenter{

    override fun showErrorLoadCupons(message: String?) {
        cuponView.showErrorLoadCupons(message)
    }

    override fun sendListCupons(cupons: List<Offer>?) {
        cuponView.showListCupons(cupons)
    }

    private var cuponInteractor: CuponInteractor = CuponInteractorImpl(this)

    override fun loadListCupons() {
        cuponInteractor.loadListCupons()
    }


}