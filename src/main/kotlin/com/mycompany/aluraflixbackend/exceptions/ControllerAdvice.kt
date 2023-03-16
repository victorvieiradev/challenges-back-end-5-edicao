package com.mycompany.aluraflixbackend.exceptions

import com.mycompany.aluraflixbackend.controller.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpClientErrorException.BadRequest
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class ControllerAdvice{
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ex.message,
            ex.detailMessageCode,
            null,
        )

        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}