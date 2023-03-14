package com.mycompany.aluraflixbackend.repository

import com.mycompany.aluraflixbackend.model.VideoModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VideoRepository: CrudRepository<VideoModel, Int> {
}