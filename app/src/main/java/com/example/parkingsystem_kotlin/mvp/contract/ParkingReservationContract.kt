package com.example.parkingsystem_kotlin.mvp.contract

import java.util.Calendar

interface ParkingReservationContract {

    interface Presenter {
        fun onPressButtonActivityParkingReservationSet()
        fun onPressButtonActivityParkingReservationCancel()
        fun onPressDatePickerInitialDate(isFocus: Boolean)
        fun onPressDatePickerEndDate(isFocus: Boolean)
    }

    interface Model {
        fun saveParkingReservationData(slot: Int, code: Int, initialDate: Calendar, endDate: Calendar)
        fun isOverlapReservation(slot: Int, initialDate: Calendar, endDate: Calendar): Boolean
        fun isCorrectTime(initialDate: Calendar, endDate: Calendar): Boolean
    }

    interface View {
        fun showToastParkingReservationIsOverlapped()
        fun parkingReservationSuccess()
        fun showToastParkingReservationWrongTime()
        fun getCodeFromInput(): String
        fun getSlotFromInput(): String
        fun cancelActivity()
        fun showDatePickerForInitialDate()
        fun showDatePickerForEndDate()
        fun getInitialDateFromInput(): Calendar
        fun getEndDateFromInput(): Calendar
    }
}
