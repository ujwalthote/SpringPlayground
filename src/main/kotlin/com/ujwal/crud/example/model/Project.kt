package com.ujwal.crud.example.model

import java.util.Date
import javax.persistence.*


@Entity
@Table(name = Project.TABLE_NAME)
class Project {
    companion object {
        const val TABLE_NAME = "project"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column
    var projectName: String? = null

    @Column
    var projectDescription : String? = null

}