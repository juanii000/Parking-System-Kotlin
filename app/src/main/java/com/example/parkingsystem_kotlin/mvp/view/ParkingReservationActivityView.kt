package com.example.parkingsystem_kotlin.mvp.view

import android.app.Activity
import android.widget.EditText
import android.widget.Toast
import com.example.parkingsystem_kotlin.databinding.ActivityParkingReservationBinding
import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationActivityContract
import com.example.parkingsystem_kotlin.mvp.view.base.ActivityView
import com.example.parkingsystem_kotlin.util.DateUtils.showDatePickerDialog

class ParkingReservationActivityView(private val binding: ActivityParkingReservationBinding, activity: Activity) :
    ParkingReservationActivityContract.View, ActivityView(activity) {

    override fun showToastOfInput(input: Int) {
        context?.let {
            Toast.makeText(it, input.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getCodeFromInput(): String = binding.inputNumberParkingCode.text.toString()

    override fun getSlotFromInput(): String = binding.inputNumberParkingSlot.text.toString()

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
