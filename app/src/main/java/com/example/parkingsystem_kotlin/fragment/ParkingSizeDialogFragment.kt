package com.example.parkingsystem_kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.parkingsystem_kotlin.databinding.DialogFragmentParkingSizeBinding
import com.example.parkingsystem_kotlin.mvp.contract.ParkingSizeDialogContract
import com.example.parkingsystem_kotlin.mvp.presenter.ParkingSizeDialogPresenter
import com.example.parkingsystem_kotlin.mvp.view.ParkingSizeDialogView

class ParkingSizeDialogFragment() : DialogFragment() {

    private lateinit var binding: DialogFragmentParkingSizeBinding
    private lateinit var presenter: ParkingSizeDialogContract.ParkingSizePresenter
    private lateinit var inputListener: SpacesParkingDialogListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogFragmentParkingSizeBinding.inflate(layoutInflater)
        inputListener = activity as SpacesParkingDialogListener
        setOnClickListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ParkingSizeDialogPresenter(ParkingSizeDialogView(this, binding))
    }

    private fun setOnClickListeners() {
        with(binding) {
            buttonSetParkingSize.setOnClickListener { presenter.setParkingSize(inputListener) }
            buttonExitParkingSize.setOnClickListener { presenter.exitDialog() }
        }
    }
}
