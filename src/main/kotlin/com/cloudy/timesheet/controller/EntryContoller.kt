package com.cloudy.timesheet.controller

import com.cloudy.timesheet.respository.TimeEntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import com.cloudy.timesheet.entity.TimeEntry
import com.cloudy.timesheet.request.EntryRequest
import com.cloudy.timesheet.request.GetByDate
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDate
import java.time.ZoneId
import java.util.*


@RestController
class EntryContoller @Autowired constructor(
        val entryRepository: TimeEntryRepository
) {

    val log  = LoggerFactory.getLogger(EntryContoller::class.java)

    @GetMapping("entries/{id}")
    fun getEntry(@PathVariable id: String): Mono<TimeEntry> {
        return entryRepository.findById(id.toLong())
    }

    @GetMapping("/entries")
    fun getEntryForDate(@RequestParam entryDate: String): Mono<TimeEntry> {
        log.info("Got this parameters ${entryDate}")
        val date: Date = Date.from(LocalDate.parse(entryDate).atStartOfDay(ZoneId.of("UTC")).toInstant())
        return entryRepository.findByEntryDate(date)
    }

    @GetMapping("/entries/search")
    fun getEntryForDateBetween(@RequestParam startDate: String, @RequestParam endDate: String ): Flux<TimeEntry> {
        log.info("Got this parameters $startDate and $endDate")
        val startD: Date = Date.from(
                LocalDate.parse(startDate)
                        .atStartOfDay(ZoneId.of("UTC"))
                        .toInstant()
                )
        val endD: Date = Date.from(
                LocalDate.parse(endDate)
                        .atStartOfDay(ZoneId.of("UTC"))
                        .toInstant()
                )
        return entryRepository.findByEntryDateBetween(startD, endD)
    }

    @PostMapping("/entries")
    @ResponseStatus(HttpStatus.CREATED)
    fun createEntry(@RequestBody entryReq: EntryRequest): Mono<TimeEntry> {
        log.info("Received req ${entryReq.entryDate}")
//        val entryDate: java.sql.Date = java.sql.Date.from(
//                LocalDate.parse(entryReq.entryDate)
//                        .atStartOfDay(ZoneId.of("UTC"))
//                        .toInstant()
//        ) as java.sql.Date

        val duration = Duration.between(entryReq.startTime, entryReq.endTime).toMinutes()

        val timeEntry = TimeEntry(null, "1", entryReq.startTime, entryReq.endTime, entryReq.entryDate, duration )

        val entry: Mono<TimeEntry> = entryRepository.save(timeEntry)

        return entry
    }






}