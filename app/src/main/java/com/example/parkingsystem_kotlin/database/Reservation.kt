package com.example.parkingsystem_kotlin.database

import java.util.Calendar

data class Reservation(
    val slot: Int,
    val code: Int,
    val initialDate: Calendar,
    val endDate: Calendar
)
