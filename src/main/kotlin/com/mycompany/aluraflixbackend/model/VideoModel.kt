package com.mycompany.aluraflixbackend.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.Length
import kotlin.math.max
import kotlin.math.min

@Entity
data class VideoModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)///
    var id: Int,
    @field:NotBlank(message = "O título não pode estar vazio.")
    var titulo: String?,
    @field:NotBlank(message = "A descrição não pode estar vazia.")
    var descricao: String?,
    @field:NotBlank(message = "A URL não pode estar vazia.")
    var url: String?
) {
}