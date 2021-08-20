package com.example.parkingsystem_kotlin.mvp.view

import android.app.Activity
import android.widget.EditText
import android.widget.Toast
import com.example.parkingsystem_kotlin.R
import com.example.parkingsystem_kotlin.databinding.ActivityParkingReservationBinding
import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationContract
import com.example.parkingsystem_kotlin.mvp.view.base.ActivityView
import com.example.parkingsystem_kotlin.util.DateUtils.getInputTypeCalendar
import com.example.parkingsystem_kotlin.util.DateUtils.showDatePickerDialog
import java.util.Calendar

class ParkingReservationView(private val binding: ActivityParkingReservationBinding, activity: Activity) :
    ParkingReservationContract.View, ActivityView(activity) {

    override fun showToastParkingReservationIsOverlapped() {
        showToast(R.string.toast_parking_reservation_activity_date_is_overlapped)
    }

    override fun parkingReservationSuccess() {
        showToast(R.string.toast_parking_reservation_activity_reservation_success)
        cancelActivity()
    }

    override fun showToastParkingReservationWrongTime() {
        showToast(R.string.toast_parking_reservation_activity_reservation_wrong_time)
    }

    override fun getCodeFromInput(): String = binding.inputNumberParkingCode.text.toString()

    override fun getSlotFromInput(): String = binding.inputNumberParkingSlot.text.toString()

    override fun getInitialDateFromInput(): Calendar =
        getInputTypeCalendar(binding.datePickerInputParkingReserveInitialDate.text.toString(), context)

    override fun getEndDateFromInput(): Calendar =
        getInputTypeCalendar(binding.datePickerInputParkingReserveEndDate.text.toString(), context)

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

    private fun showToast(text: Int) {
        context?.let {
            Toast.makeText(it, text, Toast.LENGTH_SHORT).show()
        }
    }
}
