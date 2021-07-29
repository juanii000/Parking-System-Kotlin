package com.example.parkingsystem_kotlin.mvp.contract

import android.widget.Toast
import com.example.parkingsystem_kotlin.fragment.SpacesParkingDialogListener

interface ParkingSizeDialogContract {

    interface ParkingSizePresenter {
        fun setParkingSize(inputListener: SpacesParkingDialogListener)
        fun exitDialog()
    }

    interface ParkingSizeView {
        fun getNewParkingSize(): String
        fun closeDialog()
        fun showParkingSize(parkingSize: Int)
        fun showToastWrongInput()
    }
}
