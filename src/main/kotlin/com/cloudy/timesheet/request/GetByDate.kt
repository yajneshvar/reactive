package com.cloudy.timesheet.request

data class GetByDate(
        val start: String?,
        val end: String?
)