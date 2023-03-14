package com.mycompany.aluraflixbackend.controller

import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.service.VideoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VideoController(
    val videoService: VideoService
) {
    @GetMapping("/videos")
    fun exibirVideos(): MutableIterable<VideoModel> {
        return videoService.exibirVideos()
    }
}