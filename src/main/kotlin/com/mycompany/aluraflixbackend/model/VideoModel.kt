package com.mycompany.aluraflixbackend.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length
import kotlin.math.max
import kotlin.math.min

@Entity
data class VideoModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)///
    val id: Int,
    @NotBlank(message = "O título não pode estar vazio.")
    val titulo: String,
    @NotBlank(message = "A descrição não pode estar vazia.")
    val descricao: String,
    @NotBlank(message = "A URL não pode estar vazia.")
    val url: String
) {
}