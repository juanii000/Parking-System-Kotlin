package com.example.parkingsystem_kotlin.mvp.presenter

import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract

class ParkingPresenter(
    private val model: ParkingContract.Model,
    private val view: ParkingContract.View
) : ParkingContract.Presenter {

    override fun onParkingSizeButtonPressed() {
        view.showParkingSizeDialogFragment()
        showParkingSizeToast()
    }

    override fun onParkingReservationButtonPressed() {
        view.showParkingReservationActivity(model.getParkingSize())
    }

    override fun onParkingSizeSet(parkingSize: String) {
        model.setParkingSize(parkingSize.toInt())
        showParkingSizeToast()
    }

    private fun showParkingSizeToast() {
        view.showParkingSize(model.getParkingSize())
    }
}
