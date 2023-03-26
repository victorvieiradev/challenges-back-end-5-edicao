package com.mycompany.aluraflixbackend.repository

import com.mycompany.aluraflixbackend.model.VideoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VideoRepository: JpaRepository<VideoModel, Int>{
    fun findByTituloIgnoreCaseContaining(titulo: String): List<VideoModel>
}