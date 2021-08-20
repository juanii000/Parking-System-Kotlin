package com.example.parkingsystem_kotlin.mvp.presenter

import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationContract
import java.util.Calendar

class ParkingReservationPresenter(
    private val view: ParkingReservationContract.View,
    private val model: ParkingReservationContract.Model
) : ParkingReservationContract.Presenter {

    override fun onPressButtonActivityParkingReservationSet() {
        val slot: Int = view.getSlotFromInput().toInt()
        val code: Int = view.getCodeFromInput().toInt()
        val initialDate: Calendar = view.getInitialDateFromInput()
        val endDate: Calendar = view.getEndDateFromInput()

        when {
            model.isCorrectTime(initialDate, endDate).not() -> view.showToastParkingReservationWrongTime()
            model.isOverlapReservation(slot, initialDate, endDate) -> view.showToastParkingReservationIsOverlapped()
            model.isOverlapReservation(slot, initialDate, endDate).not() -> {
                model.saveParkingReservationData(slot, code, initialDate, endDate)
                view.parkingReservationSuccess()
            }
        }
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
