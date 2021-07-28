package br.com.zupacademy.gabrielf.casadocodigo.controller;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.CategoriaDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCategoria(@RequestBody @Valid CategoriaDtoEntrada categoriaDtoEntrada){

        Categoria categoria = categoriaDtoEntrada.convertToCategoria();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();

    }

}
