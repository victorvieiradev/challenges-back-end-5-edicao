package com.mycompany.aluraflixbackend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "categorias_tb")
data class CategoriaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @field:NotBlank(message = "O Título não pode estar em branco.")
    var titulo: String?,
    @field:NotBlank(message = "A cor não pode estar em branco")
    var cor: String?,

    @field:OneToMany(mappedBy = "categoria", cascade = [CascadeType.ALL])
    var videos:List<VideoModel> = listOf<VideoModel>()
)