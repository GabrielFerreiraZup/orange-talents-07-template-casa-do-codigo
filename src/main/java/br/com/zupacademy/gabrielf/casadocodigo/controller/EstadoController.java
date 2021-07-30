package br.com.zupacademy.gabrielf.casadocodigo.controller;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Estado;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.Pais;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.EstadoDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielf.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    EntityManager em;
    @Autowired
    EstadoRepository estadoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid EstadoDtoEntrada entrada, UriComponentsBuilder uriComponentsBuilder){
        Pais pais = em.find(Pais.class,entrada.getIdPais());
        if (pais==null){
          return  ResponseEntity.badRequest().build();
        }
        else{
            Estado novoEstado = new Estado(entrada.getNome(), pais);
            estadoRepository.save(novoEstado);
            URI uri = uriComponentsBuilder.path("/estado/{id}").buildAndExpand(novoEstado.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        
    }

}
