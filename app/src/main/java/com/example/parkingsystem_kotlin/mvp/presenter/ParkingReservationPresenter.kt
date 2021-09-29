package com.example.parkingsystem_kotlin.mvp.presenter

import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationContract
import java.util.Calendar

class ParkingReservationPresenter(
    private val view: ParkingReservationContract.View,
    private val model: ParkingReservationContract.Model
) : ParkingReservationContract.Presenter {

    override fun onPressButtonActivityParkingReservationSet() {

        when {
            view.getSlotFromInput().isEmpty() -> view.showToastParkingReservationEmptyInputSlot()
            view.getCodeFromInput().isEmpty() -> view.showToastParkingReservationEmptyInputCode()
            view.getInitialTimeFromInput().isEmpty() ||
                    view.getEndTimeFromInput().isEmpty() -> view.showToastParkingReservationEmptyDateField()
            else -> {
                val parkingSize = model.getParkingSize()
                val slot: Int = view.getSlotFromInput().toInt()
                val code: Int = view.getCodeFromInput().toInt()
                val initialDate: Calendar = view.getInitialDate(view.getInitialTimeFromInput())
                val endDate: Calendar = view.getEndDate(view.getEndTimeFromInput())
                when {
                    model.isCorrectTime(initialDate, endDate).not() -> view.showToastParkingReservationWrongTime()
                    model.isOverlapReservation(slot, initialDate, endDate) -> view.showToastParkingReservationIsOverlapped()
                    slot > parkingSize -> view.showToastParkingReservationInvalidSlot(parkingSize)
                    else -> {
                        model.saveParkingReservationData(slot, code, initialDate, endDate)
                        view.parkingReservationSuccess()
                    }
                }
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

    override fun initializeParkingSpace(parkingSize: Int) {
        model.setParkingSize(parkingSize)
    }
}
