package com.mycompany.aluraflixbackend.controller

import com.mycompany.aluraflixbackend.model.CategoriaModel
import com.mycompany.aluraflixbackend.service.CategoriaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
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
@RequestMapping("/categoria")
class CategoriaController(
    val categoriaService: CategoriaService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun exibirCategorias() = categoriaService.listaCategorias()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun buscarCategoriaPeloId(@PathVariable id: Int) = categoriaService.buscarCategoriaPeloId(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun cadastrarCategoria(@RequestBody @Valid categoriaModel: CategoriaModel) =
        categoriaService.cadastrarCategoria(categoriaModel)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun atualizaCategoria(@PathVariable id: Int, @RequestBody @Valid categoriaModel: CategoriaModel) =
        categoriaService.atualizarCategoria(id, categoriaModel)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun excluirCategoria(@PathVariable id: Int) = categoriaService.excluirCategoria(id)

}