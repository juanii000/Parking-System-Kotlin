package com.example.parkingsystem_kotlin.util

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.EditText
import com.example.parkingsystem_kotlin.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateUtils {

    fun showDatePickerDialog(context: Context, textField: EditText) {
        val calendar = Calendar.getInstance()

        DatePickerDialog(
            context,
            R.style.MySpinnerDatePickerStyle,
            { _,
              yearNow,
              monthOfYear,
              dayOfMonth ->
                calendar.set(Calendar.YEAR, yearNow)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                showTimePicker(textField, calendar, context)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showTimePicker(textField: EditText, calendar: Calendar, context: Context) {
        val pattern = SimpleDateFormat(context.getString(R.string.pattern_for_date_format_all), Locale.US)

        val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            textField.setText(pattern.format(calendar.time))
        }
        TimePickerDialog(
            context,
            timeSetListener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        ).show()
    }

    fun getInputTypeCalendar(date: String, context: Context?): Calendar {
        val cal = Calendar.getInstance()
        cal.time = SimpleDateFormat(context?.getString(R.string.pattern_for_date_format_all), Locale.US).parse(date)
        return cal
    }
}
