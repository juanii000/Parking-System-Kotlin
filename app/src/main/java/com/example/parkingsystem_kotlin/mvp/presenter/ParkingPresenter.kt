package com.example.parkingsystem_kotlin.mvp.presenter

import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract

class ParkingPresenter(private val model: ParkingContract.Model, private val view: ParkingContract.View): ParkingContract.Presenter {

    override fun onParkingSizeButtonPressed() {
        view.showParkingSize(model.getParkingSize())
    }
}
