package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDtoEntrada {

    @NotBlank

    private String nome;

    public CategoriaDtoEntrada(String nome){
        this.nome = nome;
    }

    public Categoria convertToCategoria(String nome){
        return new Categoria(nome);
    }
}
