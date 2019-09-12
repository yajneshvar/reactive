package com.cloudy.timesheet.request

import java.sql.Date
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime

data class EntryRequest (val userId: String, val startTime: LocalTime,
                         val endTime: LocalTime, val entryDate: LocalDate)