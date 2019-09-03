package com.cloudy.timesheet.respository

import com.cloudy.timesheet.entity.Category
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository


interface CategoryRepository: ReactiveCrudRepository<Category, Long> {

}