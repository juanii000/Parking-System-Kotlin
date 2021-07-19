package com.example.parkingsystem_kotlin.mvp.model

import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract
import com.example.parkingsystem_kotlin.util.Constants.PARKING_SIZE

class ParkingModel: ParkingContract.Model {

    private val parkingSize: Int = PARKING_SIZE

    override fun getParkingSize(): Int = parkingSize
}
