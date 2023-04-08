package com.mycompany.aluraflixbackend.service

import com.mycompany.aluraflixbackend.exceptions.NotFoundException
import com.mycompany.aluraflixbackend.model.CategoriaModel
import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.repository.CategoriaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CategoriaService(
    val categoriaRepository: CategoriaRepository
) {
    fun listaCategorias(): MutableIterable<CategoriaModel> {
        return categoriaRepository.findAll()
    }
    fun buscarCategoriaPeloId(id: Int): CategoriaModel? {
        return categoriaRepository.findById(id).orElseThrow{NotFoundException("A categoria $id não foi encontrada.", "Sem código de erro.")}
    }
    fun excluirCategoria(id: Int): ResponseEntity<String> {
        val categoria = buscarCategoriaPeloId(id)
        if (categoria != null) {
            categoriaRepository.deleteById(categoria.id)
        }
        return ResponseEntity.ok().body("A categoria foi removida com sucesso.")
    }
    fun cadastrarCategoria(categoriaModel: CategoriaModel): CategoriaModel {
        return categoriaRepository.save(categoriaModel)
    }
    fun atualizarCategoria(id: Int, categoriaModel: CategoriaModel): CategoriaModel {
        val categoriaBuscada = buscarCategoriaPeloId(id)
        if (categoriaBuscada != null) {
            categoriaModel.id = categoriaBuscada.id
        }
        return cadastrarCategoria(categoriaModel)
    }
    fun exibirVideosPorCategoria(idCategoria: Int): List<VideoModel> {
        val categoriaBuscada = buscarCategoriaPeloId(idCategoria)
        if (categoriaBuscada != null) {
            return categoriaBuscada.videos
        }
        return throw NotFoundException("Sem código de erro", "Não existe vídeos cadastrados nesta categoria.")
    }
}