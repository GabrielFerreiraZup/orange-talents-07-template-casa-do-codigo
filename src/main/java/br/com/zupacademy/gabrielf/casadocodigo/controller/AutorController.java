package br.com.zupacademy.gabrielf.casadocodigo.controller;



import br.com.zupacademy.gabrielf.casadocodigo.modelo.Autor;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.AutorDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroAutor(@RequestBody @Valid AutorDtoEntrada autorDtoEntrada){
        Autor autor = autorDtoEntrada.convertToAutor();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }



}
