package com.ujwal.crud.example.exception

class ResourceNotFoundException(override val message: String = "Entity not found") : Exception(message)