package com.cloudy.timesheet.controller

import com.cloudy.timesheet.respository.TimeEntryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import com.cloudy.timesheet.entity.TimeEntry
import com.cloudy.timesheet.request.GetByDate
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.util.*


@RestController

class EntryContoller @Autowired constructor(
        val entryRepository: TimeEntryRepository
) {

    val log  = LoggerFactory.getLogger(EntryContoller::class.java)

    @GetMapping("entry/{id}")
   fun getEntry(@PathVariable id: String): Mono<TimeEntry> {
        return entryRepository.findById(id.toLong())
    }

    @GetMapping("/entries")
    fun getEntryForDate(@RequestParam entryDate: String): Mono<TimeEntry> {
        log.info("Got this parameters ${entryDate}")
        //val date: Date = Date.from(LocalDate.parse(entryDate).atStartOfDay().toInstant()
       // return entryRepository.findByEntryDate(date)
        return Mono.empty()
    }







}