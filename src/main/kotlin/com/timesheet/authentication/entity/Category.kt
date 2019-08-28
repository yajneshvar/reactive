package com.timesheet.authentication.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("categories")
data class Category (
    @Id
    val id: Long,
    val name: String
)