package com.example.parkingsystem_kotlin.mvp.view

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.parkingsystem_kotlin.R
import com.example.parkingsystem_kotlin.databinding.DialogFragmentParkingSizeBinding
import com.example.parkingsystem_kotlin.mvp.contract.ParkingSizeDialogContract
import com.example.parkingsystem_kotlin.mvp.view.base.FragmentView
import com.example.parkingsystem_kotlin.util.showToast

class ParkingSizeDialogView(fragment: Fragment, private val binding: DialogFragmentParkingSizeBinding) :
    FragmentView(fragment), ParkingSizeDialogContract.ParkingSizeView {

    override fun getNewParkingSize(): String {
        return binding.numberInputDialogFragmentParkingSize.text.toString()
    }

    override fun showParkingSize(parkingSize: Int) {
        context?.showToast(parkingSize.toString())
    }

    override fun showToastWrongInput() {
        context?.let {
            it.showToast(it.getString(R.string.toast_dialog_parking_space_wrong_input_msg))
        }
    }

    override fun closeDialog() {
        fragment?.let {
            (it as DialogFragment).dismiss()
        }
    }
}
