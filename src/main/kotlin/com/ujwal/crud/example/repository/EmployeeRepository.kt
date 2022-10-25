package com.ujwal.crud.example.repository

import com.ujwal.crud.example.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {
    fun findByFirstNameOrLastNameOrEmail(firstName: String?, lastName : String?, email : String?): List<Employee>

    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 or e.lastName = ?1")
    fun getAllEmployeesByQuery(query: String?) : List<Employee>
}