package com.example.parkingsystem_kotlin.mvp.model

import com.example.parkingsystem_kotlin.database.ParkingReservationDB
import com.example.parkingsystem_kotlin.database.Reservation
import com.example.parkingsystem_kotlin.mvp.contract.ParkingReservationContract
import com.example.parkingsystem_kotlin.util.Constants
import java.util.Calendar

class ParkingReservationModel : ParkingReservationContract.Model {

    private var parkingSize: Int = Constants.PARKING_SIZE

    override fun setParkingSize(parkingSize: Int) {
        this.parkingSize = parkingSize
    }

    override fun getParkingSize(): Int = parkingSize

    override fun saveParkingReservationData(slot: Int, code: Int, initialDate: Calendar, endDate: Calendar) {
        val reservation = Reservation(slot, code, initialDate, endDate)
        ParkingReservationDB.setReservation(reservation)
    }

    override fun isCorrectTime(initialDate: Calendar, endDate: Calendar): Boolean {
        return initialDate.before(endDate)
    }

    override fun isOverlapReservation(slot: Int, initialDate: Calendar, endDate: Calendar): Boolean {
        ParkingReservationDB.hashMapParkingReserve[slot]?.forEach { reservation ->
            if (initialDate.before(reservation.initialDate) && endDate.after(reservation.initialDate) ||
                initialDate.before(reservation.endDate) && endDate.after(reservation.endDate) ||
                initialDate.after(reservation.initialDate) && endDate.before(reservation.endDate)
                || initialDate == reservation.initialDate && endDate == reservation.endDate
            ) {
                return true
            }
        }
        return false
    }
}
