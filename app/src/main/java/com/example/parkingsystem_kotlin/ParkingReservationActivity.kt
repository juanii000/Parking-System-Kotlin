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
import com.example.parkingsystem_kotlin.util.Constants.EXTRA_PARKING_SIZE as EXTRA_PARKING_SIZE
import com.example.parkingsystem_kotlin.util.Constants.PARKING_SIZE as PARKING_SIZE_DEFAULT

class ParkingReservationActivity : AppCompatActivity() {

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
        presenter.initializeParkingSpace(intent.getIntExtra(EXTRA_PARKING_SIZE, PARKING_SIZE_DEFAULT))
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

    companion object {
        fun getIntent(context: Context, parkingSize: Int) = Intent(context, ParkingReservationActivity::class.java).apply {
            putExtra(EXTRA_PARKING_SIZE, parkingSize)
        }
    }
}
