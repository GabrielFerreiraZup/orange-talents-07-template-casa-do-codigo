package br.com.zupacademy.gabrielf.casadocodigo.controller;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Pais;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.PaisDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarPais(@RequestBody @Valid PaisDtoEntrada entrada, UriComponentsBuilder uriComponentsBuilder){
        Pais novoPais = entrada.convertToPais();
        paisRepository.save(novoPais);
        URI uri = uriComponentsBuilder.path("/pais/{id}").buildAndExpand(novoPais.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
