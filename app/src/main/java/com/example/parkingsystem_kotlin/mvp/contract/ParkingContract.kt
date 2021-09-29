package com.example.parkingsystem_kotlin.mvp.contract

interface ParkingContract {
    interface Presenter {
        fun onParkingSizeButtonPressed()
        fun onParkingReservationButtonPressed()
        fun onParkingSizeSet(parkingSize: String)
    }

    interface Model {
        fun setParkingSize(parkingSize: Int)
        fun getParkingSize(): Int
    }

    interface View {
        fun showParkingSizeDialogFragment()
        fun showParkingReservationActivity(parkingSize: Int)
        fun showParkingSize(parkingSize: Int)
    }
}
