package com.timesheet.authentication

import com.timesheet.authentication.respository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.core.publisher.Mono

@SpringBootApplication
class AuthenticationApplication

//@Autowired
//lateinit var categoryRepository: CategoryRepository

fun main(args: Array<String>) {
	val runApplication = runApplication<AuthenticationApplication>(*args)

	var categoryRepository: CategoryRepository

	categoryRepository = runApplication.getBean(CategoryRepository::class.java)

	val category = categoryRepository.findById(1)

	println("TEST")

	category
			.subscribe( {cat -> println("${cat.name}")},
					{error -> println("${error}")},
					{ println("Complete!!!")})




}
