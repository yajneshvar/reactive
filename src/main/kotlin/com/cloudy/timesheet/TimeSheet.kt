package com.cloudy.timesheet

import com.cloudy.timesheet.respository.CategoryRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TimeSheet

//@Autowired
//lateinit var categoryRepository: CategoryRepository

fun main(args: Array<String>) {
	val runApplication = runApplication<TimeSheet>(*args)

	var categoryRepository: CategoryRepository

	categoryRepository = runApplication.getBean(CategoryRepository::class.java)

	val category = categoryRepository.findById(1)

	println("TEST")

	category.subscribe( {cat -> println("${cat.name}")},
					{error -> println("${error}")},
					{ println("Complete!!!")})





}
