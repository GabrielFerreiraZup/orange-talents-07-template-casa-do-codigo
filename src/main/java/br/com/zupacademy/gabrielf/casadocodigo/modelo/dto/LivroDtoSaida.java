package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDtoSaida {

    private Long id;
    private String titulo;

    public LivroDtoSaida(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
