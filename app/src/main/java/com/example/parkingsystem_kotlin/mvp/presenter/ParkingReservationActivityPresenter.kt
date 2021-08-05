package com.example.parkingsystem_kotlin.mvp.presenter

import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationActivityContract

class ParkingReservationActivityPresenter(private val view: ParkingReservationActivityContract.View) :
    ParkingReservationActivityContract.Presenter {

    override fun onPressButtonActivityParkingReservationSet() {
        view.showToastOfInput(view.getSlotFromInput().toInt())
        view.showToastOfInput(view.getCodeFromInput().toInt())
    }

    override fun onPressButtonActivityParkingReservationCancel() {
        view.cancelActivity()
    }

    override fun onPressDatePickerInitialDate(isFocus: Boolean) {
        if (isFocus) {
            view.showDatePickerForInitialDate()
        }
    }

    override fun onPressDatePickerEndDate(isFocus: Boolean) {
        if (isFocus) {
            view.showDatePickerForEndDate()
        }
    }
}
