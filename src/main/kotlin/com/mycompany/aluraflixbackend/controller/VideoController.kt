package com.mycompany.aluraflixbackend.controller

import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.service.VideoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/videos")
class VideoController(
    val videoService: VideoService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun exibirVideos(): MutableIterable<VideoModel> {
        return videoService.exibirVideos()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarVideo(@Valid @RequestBody videoModel: VideoModel): VideoModel {
        return videoService.cadastrarVideo(videoModel)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun buscarVideoPeloId(@PathVariable(value = "id") id: Int): VideoModel {
        return videoService.buscarVideoPeloId(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun excluirVideoPeloId(@PathVariable(value = "id") id: Int): ResponseEntity<String> {
        return videoService.excluirVideoPeloId(id)
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun atualizaVideo(@PathVariable(value = "id") id: Int, @RequestBody videoModel: VideoModel): VideoModel {
        return videoService.atualizaVideo(id, videoModel)
    }

}