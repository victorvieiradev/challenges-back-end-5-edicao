package com.mycompany.aluraflixbackend.service

import com.mycompany.aluraflixbackend.exceptions.NotFoundException
import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.repository.VideoRepository
import org.springframework.beans.BeanUtils
import org.springframework.http.ResponseEntity
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
    fun excluirVideoPeloId(id: Int): ResponseEntity<String> {
        val videoPeloId = buscarVideoPeloId(id)
        videoRepository.deleteById(videoPeloId.id)
        return ResponseEntity.ok().body("O vídeo $id foi removido com sucesso.")
    }
    fun atualizaVideo(id: Int, videoModel: VideoModel): VideoModel {
        val videoEncontrado = buscarVideoPeloId(id)
        videoModel.id = videoEncontrado.id
        BeanUtils.copyProperties(videoModel, videoEncontrado)
        return cadastrarVideo(videoEncontrado)
    }
}