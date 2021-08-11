package com.example.parkingsystem_kotlin.mvp.contract

interface ParkingReservationActivityContract {

    interface Presenter {
        fun onPressButtonActivityParkingReservationSet()
        fun onPressButtonActivityParkingReservationCancel()
        fun onPressDatePickerInitialDate(isFocus: Boolean)
        fun onPressDatePickerEndDate(isFocus: Boolean)
    }

    interface View {
        fun showToastOfInput(input: Int)
        fun getCodeFromInput(): String
        fun getSlotFromInput(): String
        fun cancelActivity()
        fun showDatePickerForInitialDate()
        fun showDatePickerForEndDate()
    }
}
