package com.example.parkingsystem_kotlin.mvp.contract

interface ParkingContract {
    interface Presenter{
        fun onParkingSizeButtonPressed()
        fun onParkingSizeSet(parkingSize: String)
    }

    interface Model{
        fun setParkingSize(parkingSize: Int)
        fun getParkingSize(): Int
    }

    interface View{
        fun showParkingSizeDialogFragment()
        fun showParkingSize(parkingSize: Int)
    }
}
