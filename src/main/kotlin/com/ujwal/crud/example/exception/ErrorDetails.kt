package com.ujwal.crud.example.exception

import java.util.*

data class ErrorDetails(
    var timeStamp: Date? = null,
    var message: String? = null,
    var details: String? = null
)