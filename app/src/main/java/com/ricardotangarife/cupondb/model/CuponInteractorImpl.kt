package com.ricardotangarife.cupondb.model

import com.ricardotangarife.cupondb.presenter.CuponPresenter

class CuponInteractorImpl(var cuponPresenter: CuponPresenter): CuponInteractor{

    private var cuponRepository: CuponRepository = CuponRepositoryImpl(cuponPresenter)

    override fun loadListCupons() {
        cuponRepository.loadListCupons()
    }
}