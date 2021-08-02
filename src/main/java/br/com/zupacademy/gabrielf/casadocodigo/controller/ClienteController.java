package br.com.zupacademy.gabrielf.casadocodigo.controller;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Cliente;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.Estado;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.Pais;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.dto.ClienteDtoEntrada;
import br.com.zupacademy.gabrielf.casadocodigo.repository.ClienteRepository;
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

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    EntityManager em;
    @Autowired
    ClienteRepository clienteRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ClienteDtoEntrada clienteDtoEntrada, UriComponentsBuilder uriComponentsBuilder){
        Pais pais = em.find(Pais.class,clienteDtoEntrada.getIdPais());
        Estado estado = em.find(Estado.class,clienteDtoEntrada.getIdEstado());
        Cliente novoCliente = new Cliente(
                clienteDtoEntrada.getEmail(),
                clienteDtoEntrada.getNome(),
                clienteDtoEntrada.getSobrenome(),
                clienteDtoEntrada.getDocumento(),
                clienteDtoEntrada.getEndereco(),
                clienteDtoEntrada.getComplemento(),
                clienteDtoEntrada.getCidade(),
                pais,
                estado,
                clienteDtoEntrada.getTelefone(),
                clienteDtoEntrada.getCep());
        clienteRepository.save(novoCliente);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(novoCliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
