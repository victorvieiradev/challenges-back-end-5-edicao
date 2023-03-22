package com.mycompany.aluraflixbackend.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
data class CategoriaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @field:NotBlank(message = "O Título não pode estar em branco.")
    var titulo: String?,
    @field:NotBlank(message = "A cor não pode estar em branco")
    var cor: String?
)