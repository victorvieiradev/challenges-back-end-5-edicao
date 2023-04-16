package com.mycompany.aluraflixbackend.service

import com.mycompany.aluraflixbackend.model.CategoriaModel
import com.mycompany.aluraflixbackend.model.VideoModel
import com.mycompany.aluraflixbackend.repository.CategoriaRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class CategoriaServiceTest {
    @MockK
    private lateinit var categoriaRepository: CategoriaRepository

    @InjectMockKs
    private lateinit var categoriaService: CategoriaService

    @Test
    fun listaCategorias() {
        val categorias = listOf(criarCategoria(), criarCategoria(), criarCategoria())
        every { categoriaRepository.findAll() } returns categorias
        val listaCategorias = categoriaService.listaCategorias()
        val listaCategorias1 = categoriaService.listaCategorias()
        assertEquals(categorias, listaCategorias)
        assertEquals(categorias, listaCategorias1)
        verify(exactly = 2) {categoriaRepository.findAll()}
    }

    @Test
    fun buscarCategoriaPeloId() {
    }

    @Test
    fun excluirCategoria() {
    }

    @Test
    fun cadastrarCategoria() {
    }

    @Test
    fun atualizarCategoria() {
    }

    @Test
    fun exibirVideosPorCategoria() {
    }

    @Test
    fun getCategoriaRepository() {
    }

    private fun criarCategoria(
    id: Int = 1,
    titulo : String = "primeira categoria",
    cor: String = "exemplo categoria.",
    videos: List<VideoModel> = listOf()
    ) = CategoriaModel(id, titulo, cor, videos)
}