package com.example.parkingsystem_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parkingsystem_kotlin.mvp.view.ParkingView
import com.example.parkingsystem_kotlin.mvp.model.ParkingModel
import com.example.parkingsystem_kotlin.databinding.ActivityMainBinding
import com.example.parkingsystem_kotlin.fragment.SpacesParkingDialogListener
import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract
import com.example.parkingsystem_kotlin.mvp.presenter.ParkingPresenter

class MainActivity : AppCompatActivity(), SpacesParkingDialogListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: ParkingContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ParkingPresenter(ParkingModel(), ParkingView(this))
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        with(binding) {
            buttonMainParkingSize.setOnClickListener { presenter.onParkingSizeButtonPressed() }
            buttonMainParkingReservation.setOnClickListener { presenter.onParkingReservationButtonPressed() }
        }
    }

    override fun setParkingSize(parkingSize: String) {
        presenter.onParkingSizeSet(parkingSize)
    }
}
