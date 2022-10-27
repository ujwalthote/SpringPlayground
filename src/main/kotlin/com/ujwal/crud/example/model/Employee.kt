package com.ujwal.crud.example.model

import com.ujwal.crud.example.model.Employee.Companion.TABLE_NAME
import javax.persistence.*



@Entity
@Table(name = TABLE_NAME)
class Employee {
    companion object{
        const val TABLE_NAME = "employees"
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "firstName")
    var firstName: String? = null

    @Column(name = "lastName")
    var lastName: String? = null

    @Column(name = "email")
    var email: String? = null

    @OneToMany
    @JoinColumn(name = "id")
    var projects : List<Project>? = null
}
