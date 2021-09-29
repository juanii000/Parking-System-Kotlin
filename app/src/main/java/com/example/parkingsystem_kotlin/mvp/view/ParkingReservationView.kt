package com.example.parkingsystem_kotlin.mvp.view

import android.app.Activity
import android.widget.EditText
import com.example.parkingsystem_kotlin.R
import com.example.parkingsystem_kotlin.databinding.ActivityParkingReservationBinding
import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationContract
import com.example.parkingsystem_kotlin.mvp.view.base.ActivityView
import com.example.parkingsystem_kotlin.util.DateUtils.getInputTypeCalendar
import com.example.parkingsystem_kotlin.util.DateUtils.showDatePickerDialog
import com.example.parkingsystem_kotlin.util.showToast
import java.util.Calendar

class ParkingReservationView(private val binding: ActivityParkingReservationBinding, activity: Activity) :
    ParkingReservationContract.View, ActivityView(activity) {

    override fun showToastParkingReservationEmptyDateField() {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_reservation_empty_date_field))
        }
    }

    override fun showToastParkingReservationIsOverlapped() {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_date_is_overlapped))
        }
    }

    override fun parkingReservationSuccess() {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_reservation_success))
        }
        cancelActivity()
    }

    override fun showToastParkingReservationWrongTime() {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_reservation_wrong_time))
        }
    }

    override fun showToastParkingReservationEmptyInputSlot() {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_reservation_empty_input_slot))
        }
    }

    override fun showToastParkingReservationEmptyInputCode() {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_reservation_empty_input_code))
        }
    }

    override fun showToastParkingReservationInvalidSlot(parkingSize: Int) {
        context?.let {
            it.showToast(it.getString(R.string.toast_parking_reservation_activity_reservation_invalid_slot, parkingSize))
        }
    }

    override fun getCodeFromInput(): String = binding.inputNumberParkingCode.text.toString()

    override fun getSlotFromInput(): String = binding.inputNumberParkingSlot.text.toString()

    override fun getInitialTimeFromInput(): String = binding.datePickerInputParkingReserveInitialDate.text.toString()

    override fun getEndTimeFromInput(): String = binding.datePickerInputParkingReserveEndDate.text.toString()

    override fun getInitialDate(text: String): Calendar =
        getInputTypeCalendar(text, context)

    override fun getEndDate(text: String): Calendar =
        getInputTypeCalendar(text, context)

    override fun cancelActivity() {
        activity?.finish()
    }

    override fun showDatePickerForInitialDate() {
        displayDateAndTimePickerDialog(binding.datePickerInputParkingReserveInitialDate)
    }

    override fun showDatePickerForEndDate() {
        displayDateAndTimePickerDialog(binding.datePickerInputParkingReserveEndDate)
    }

    private fun displayDateAndTimePickerDialog(textField: EditText) {
        context?.let { showDatePickerDialog(it, textField) }
        textField.clearFocus()
    }
}
