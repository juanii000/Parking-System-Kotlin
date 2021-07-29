package com.example.parkingsystem_kotlin.mvp.model

import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract
import com.example.parkingsystem_kotlin.util.Constants

class ParkingModel() : ParkingContract.Model {

    private var parkingSize: Int = Constants.PARKING_SIZE

    override fun setParkingSize(parkingSize: Int) {
        this.parkingSize = parkingSize
    }

    override fun getParkingSize(): Int = parkingSize
}
