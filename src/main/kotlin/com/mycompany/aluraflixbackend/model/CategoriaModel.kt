package com.mycompany.aluraflixbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "TB_CATEGORIA")
data class CategoriaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @field:NotBlank(message = "O Título não pode estar em branco.")
    var titulo: String?,
    @field:NotBlank(message = "A cor não pode estar em branco")
    var cor: String?,
    @field:OneToMany
    var videos: MutableList<VideoModel>?
)