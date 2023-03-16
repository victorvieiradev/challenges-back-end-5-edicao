package com.mycompany.aluraflixbackend.exceptions

class NotFoundException(
    override val message: String,
    val errorCode: String
) : Exception()