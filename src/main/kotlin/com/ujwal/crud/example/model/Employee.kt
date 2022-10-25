package com.ujwal.crud.example.model

import javax.persistence.*

const val TABLE_NAME = "employees"

@Entity
@Table(name = TABLE_NAME)
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "firstName")
    var firstName: String? = null

    @Column(name = "lastName")
    var lastName: String? = null

    @Column(name = "email")
    var email: String? = null
}
