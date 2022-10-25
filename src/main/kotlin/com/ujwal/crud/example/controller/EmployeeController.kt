package com.ujwal.crud.example.controller

import com.ujwal.crud.example.exception.ResourceNotFoundException
import com.ujwal.crud.example.model.Employee
import com.ujwal.crud.example.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController {

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    @GetMapping
    fun getEmployees(): ResponseEntity<List<Employee>> {
        return ResponseEntity.ok(employeeRepository.findAll())
    }


    @GetMapping("{id}")
    fun getEmployeeById(@PathVariable(value = "id") id: Long): ResponseEntity<Employee> {
        val result = employeeRepository.findById(id)
        return if (result.isPresent)
            ResponseEntity.ok(result.get())
        else
            throw ResourceNotFoundException()
    }

    @PostMapping
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<Employee> {
        return ResponseEntity.ok(employeeRepository.save(employee))
    }

    @PutMapping("{id}")
    fun updateEmployee(
        @PathVariable(value = "id") id: Long,
        @RequestBody employee: Employee
    ): ResponseEntity<Employee> {
        val employeeResult = employeeRepository.findById(id)
        return if (employeeResult.isPresent) {
            val employeeFromDb: Employee = employeeResult.get()
            employee.id = employeeFromDb.id
            ResponseEntity.ok(employeeRepository.save(employee))
        } else {
            throw ResourceNotFoundException()
        }
    }

    @DeleteMapping("{id}")
    fun deleteEmployee(@PathVariable(value = "id") id: Long): ResponseEntity<Boolean> {
        val employeeResult = employeeRepository.findById(id)
        return if (employeeResult.isPresent) {
            employeeRepository.deleteById(id)
            ResponseEntity.ok(true)
        } else {
            throw ResourceNotFoundException()
        }
    }

    @GetMapping("search")
    fun search(
        @RequestParam(required = true) query: String?
    ): ResponseEntity<List<Employee>> =
//        ResponseEntity.ok(employeeRepository.findByFirstNameOrLastNameOrEmail(firstName, lastName, email))
        ResponseEntity.ok(employeeRepository.getAllEmployeesByQuery(query))
}
