package com.example.parkingsystem_kotlin.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.parkingsystem_kotlin.mvp.contract.ParkingContract
import com.example.parkingsystem_kotlin.mvp.view.base.ActivityView

class ParkingView(activity: Activity): ActivityView(activity), ParkingContract.View {

    override fun showParkingSize(parkingSize: Int) {
        context?.let {
            Toast.makeText(it, parkingSize.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
