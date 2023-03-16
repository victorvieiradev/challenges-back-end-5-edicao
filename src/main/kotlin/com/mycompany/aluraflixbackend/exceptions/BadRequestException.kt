package com.mycompany.aluraflixbackend.exceptions
class BadRequestException(
    override val message: String,
    val errorCode: String
) : Exception()