package com.example.parkingsystem_kotlin.mvp.contract

interface ParkingContract {
    interface Presenter{
        fun onParkingSizeButtonPressed()
    }

    interface Model{
        fun getParkingSize(): Int
    }

    interface View{
        fun showParkingSize(parkingSize: Int)
    }
}
