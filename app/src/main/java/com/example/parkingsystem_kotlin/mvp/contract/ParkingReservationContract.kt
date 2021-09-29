package com.example.parkingsystem_kotlin.mvp.contract

import java.util.Calendar

interface ParkingReservationContract {

    interface Presenter {
        fun onPressButtonActivityParkingReservationSet()
        fun onPressButtonActivityParkingReservationCancel()
        fun onPressDatePickerInitialDate(isFocus: Boolean)
        fun onPressDatePickerEndDate(isFocus: Boolean)
        fun initializeParkingSpace(parkingSize: Int)
    }

    interface Model {
        fun saveParkingReservationData(slot: Int, code: Int, initialDate: Calendar, endDate: Calendar)
        fun isOverlapReservation(slot: Int, initialDate: Calendar, endDate: Calendar): Boolean
        fun isCorrectTime(initialDate: Calendar, endDate: Calendar): Boolean
        fun setParkingSize(parkingSize: Int)
        fun getParkingSize(): Int
    }

    interface View {
        fun getCodeFromInput(): String
        fun getSlotFromInput(): String
        fun getInitialTimeFromInput(): String
        fun getEndTimeFromInput(): String
        fun cancelActivity()
        fun showDatePickerForInitialDate()
        fun showDatePickerForEndDate()
        fun getInitialDate(text: String): Calendar
        fun getEndDate(text: String): Calendar
        fun showToastParkingReservationEmptyDateField()
        fun showToastParkingReservationIsOverlapped()
        fun parkingReservationSuccess()
        fun showToastParkingReservationWrongTime()
        fun showToastParkingReservationEmptyInputSlot()
        fun showToastParkingReservationEmptyInputCode()
        fun showToastParkingReservationInvalidSlot(parkingSize: Int)
    }
}
