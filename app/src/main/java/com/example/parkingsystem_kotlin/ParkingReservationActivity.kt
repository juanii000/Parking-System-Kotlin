package com.example.parkingsystem_kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType.TYPE_NULL
import androidx.appcompat.app.AppCompatActivity
import com.example.parkingsystem_kotlin.databinding.ActivityParkingReservationBinding
import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationContract
import com.example.parkingsystem_kotlin.mvp.model.ParkingReservationModel
import com.example.parkingsystem_kotlin.mvp.presenter.ParkingReservationPresenter
import com.example.parkingsystem_kotlin.mvp.view.ParkingReservationView

class ParkingReservationActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context) = Intent(context, ParkingReservationActivity::class.java)
    }

    private lateinit var binding: ActivityParkingReservationBinding
    private lateinit var presenter: ParkingReservationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParkingReservationBinding.inflate(layoutInflater)
        with(binding) {
            datePickerInputParkingReserveInitialDate.inputType = TYPE_NULL
            datePickerInputParkingReserveEndDate.inputType = TYPE_NULL
        }
        setContentView(binding.root)
        presenter = ParkingReservationPresenter(
            ParkingReservationView(binding, this),
            ParkingReservationModel()
        )
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        with(binding) {
            buttonActivityParkingReservationSet.setOnClickListener { presenter.onPressButtonActivityParkingReservationSet() }
            buttonActivityParkingReservationCancel.setOnClickListener { presenter.onPressButtonActivityParkingReservationCancel() }
            datePickerInputParkingReserveInitialDate.setOnFocusChangeListener { _, isFocus ->
                presenter.onPressDatePickerInitialDate(isFocus)
            }
            datePickerInputParkingReserveEndDate.setOnFocusChangeListener { _, isFocus ->
                presenter.onPressDatePickerEndDate(isFocus)
            }
        }
    }
}
