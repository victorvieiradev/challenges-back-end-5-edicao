package com.mycompany.aluraflixbackend.repository

import com.mycompany.aluraflixbackend.model.CategoriaModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: CrudRepository<CategoriaModel, Int>