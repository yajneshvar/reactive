package com.cloudy.timesheet.respository

import com.cloudy.timesheet.entity.TimeEntry
import org.springframework.data.r2dbc.repository.query.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.*


interface TimeEntryRepository: ReactiveCrudRepository<TimeEntry, Long> {

    @Query("select * from time_entry where entry_date = :entryDate")
   fun findByEntryDate(entryDate: Date): Mono<TimeEntry>
}