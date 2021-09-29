package com.example.parkingsystem_kotlin.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.parkingsystem_kotlin.ParkingReservationActivity
import com.example.parkingsystem_kotlin.fragment.ParkingSizeDialogFragment
import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract
import com.example.parkingsystem_kotlin.mvp.view.base.ActivityView
import com.example.parkingsystem_kotlin.util.Constants

class ParkingView(activity: Activity) : ActivityView(activity), ParkingContract.View {

    override fun showParkingSizeDialogFragment() {
        ParkingSizeDialogFragment().show(fragmentManager, Constants.TAG_PARKING_SIZE_DIALOG)
    }

    override fun showParkingReservationActivity(parkingSize: Int) {
        activity?.startActivity(context?.let { ParkingReservationActivity.getIntent(it, parkingSize) })
    }

    override fun showParkingSize(parkingSize: Int) {
        context?.let {
            Toast.makeText(it, parkingSize.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
