package com.mycompany.aluraflixbackend.service

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
}