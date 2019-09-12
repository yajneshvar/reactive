package com.cloudy.timesheet.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date
import java.sql.Time
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import javax.annotation.Generated

@Table("time_entry")
data class TimeEntry(@Id val id: Long?,
                     val userId: String, val startTime: LocalTime,
                     val endTime: LocalTime, val entryDate: LocalDate,
                     val duration: Long)