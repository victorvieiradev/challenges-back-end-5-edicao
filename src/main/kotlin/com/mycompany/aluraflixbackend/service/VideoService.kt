package com.mycompany.aluraflixbackend.service

import com.mycompany.aluraflixbackend.exceptions.NotFoundException
import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.repository.VideoRepository
import org.springframework.stereotype.Service

@Service
class VideoService(
    val videoRepository: VideoRepository
) {
    fun exibirVideos(): MutableIterable<VideoModel> {
        return videoRepository.findAll()
    }
    fun cadastrarVideo(videoModel: VideoModel): VideoModel {
        return videoRepository.save(videoModel)
    }
    fun buscarVideoPeloId(id: Int): VideoModel {
        return  videoRepository.findById(id).orElseThrow{ NotFoundException("O vídeo $id, não foi encontrado", " ")}
    }
}