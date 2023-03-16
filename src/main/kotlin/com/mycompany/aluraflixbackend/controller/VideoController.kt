package com.mycompany.aluraflixbackend.controller

import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.service.VideoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class VideoController(
    val videoService: VideoService
) {
    @GetMapping("/videos")
    @ResponseStatus(HttpStatus.OK)
    fun exibirVideos(): MutableIterable<VideoModel> {
        return videoService.exibirVideos()
    }
    @PostMapping("/videos")
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarVideo(@Valid @RequestBody videoModel: VideoModel): VideoModel {
        return videoService.cadastrarVideo(videoModel)
    }
}