package com.ujwal.crud.example.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundException(
        resourceNotFoundException: ResourceNotFoundException,
        request: WebRequest
    ): ResponseEntity<ErrorDetails> = ResponseEntity(
        ErrorDetails(Date(), resourceNotFoundException.message, request.getDescription(false)),
        HttpStatus.NOT_FOUND
    )

    @ExceptionHandler(Exception::class)
    fun globalExceptionHandler(exception: Exception, request: WebRequest): ResponseEntity<ErrorDetails> =
        ResponseEntity.internalServerError()
            .body(ErrorDetails(Date(), exception.message, request.getDescription(false)))
}