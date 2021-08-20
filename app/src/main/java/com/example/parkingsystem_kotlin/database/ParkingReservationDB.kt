package com.example.parkingsystem_kotlin.database

object ParkingReservationDB {

    val hashMapParkingReserve: MutableMap<Int, MutableList<Reservation>> = HashMap()

    fun setReservation(reservation: Reservation) {

        if (hashMapParkingReserve.containsKey(reservation.slot)) {
            hashMapParkingReserve[reservation.slot]?.add(reservation)
        } else {
            hashMapParkingReserve[reservation.slot] = mutableListOf(reservation)
        }
    }
}
