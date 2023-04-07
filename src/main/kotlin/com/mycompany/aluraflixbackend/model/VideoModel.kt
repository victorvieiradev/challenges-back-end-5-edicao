package com.mycompany.aluraflixbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "videos_tb")
data class VideoModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)///
    var id: Int,
    @field:NotBlank(message = "O título não pode estar vazio.")
    var titulo: String?,
    @field:NotBlank(message = "A descrição não pode estar vazia.")
    var descricao: String?,
    @field:NotBlank(message = "A URL não pode estar vazia.")
    var url: String?,
    @field:JsonIgnore
    @field:ManyToOne
    var categoria: CategoriaModel?
)