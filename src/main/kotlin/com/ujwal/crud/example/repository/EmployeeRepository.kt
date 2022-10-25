package com.ujwal.crud.example.repository

import com.ujwal.crud.example.model.Employee
import com.ujwal.crud.example.model.TABLE_NAME
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {

    @Query
    fun findByFirstName(firstName: String): List<Employee>

}