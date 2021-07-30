package com.example.parkingsystem_kotlin.mvp.presenter

import com.example.parkingsystem_kotlin.fragment.SpacesParkingDialogListener
import com.example.parkingsystem_kotlin.mvp.contract.ParkingSizeDialogContract
import com.example.parkingsystem_kotlin.util.Constants

class ParkingSizeDialogPresenter(
    private val view: ParkingSizeDialogContract.ParkingSizeView,
) : ParkingSizeDialogContract.ParkingSizePresenter {

    companion object {
        const val PARKING_MAX_SIZE: Int = 10000
    }

    override fun setParkingSize(inputListener: SpacesParkingDialogListener) {
        val parkingSize = view.getNewParkingSize()
        if (parkingSize.isNotEmpty() && parkingSize.toLong() < PARKING_MAX_SIZE) {
            inputListener.setParkingSize(parkingSize)
            view.closeDialog()
        } else {
            view.showToastWrongInput()
        }
    }

    override fun exitDialog() {
        view.closeDialog()
    }
}
