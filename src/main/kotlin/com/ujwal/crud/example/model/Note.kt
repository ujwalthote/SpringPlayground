package com.ujwal.crud.example.model

import java.util.Date
import javax.persistence.*


@Entity
@Table(name = Note.TABLE_NAME)
class Note {
    companion object {
        const val TABLE_NAME = "notes"
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column
    var content: String? = null

    @Column
    var timeStamp: Date? = null
}