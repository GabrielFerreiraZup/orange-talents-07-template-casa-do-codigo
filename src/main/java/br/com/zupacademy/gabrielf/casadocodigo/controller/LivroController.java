package br.com.zupacademy.gabrielf.casadocodigo.controller;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Livro;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.LivroDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.LivroDtoSaida;
import br.com.zupacademy.gabrielf.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    EntityManager em;
    @Autowired
    LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarLivro(@RequestBody @Valid LivroDtoEntrada entrada){
        Livro novoLivro = entrada.convertToCategoria(em);
        livroRepository.save(novoLivro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LivroDtoSaida> listarLivros(){
        List<Livro> livrosPuros = livroRepository.findAll();
        List<LivroDtoSaida> livrosSaida = new ArrayList<>();

        for (Livro livro:livrosPuros) {
            livrosSaida.add(new LivroDtoSaida(livro));
        }

        return livrosSaida;
    }

}
