package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDtoEntrada {

    @NotBlank(message = "Nome nao pode ser nulo")
    private String nome;

    public String getNome() {
        return nome;
    }

    public CategoriaDtoEntrada(){}

    public CategoriaDtoEntrada(String nome){
        this.nome = nome;
    }

    public Categoria convertToCategoria(){
        return new Categoria(this.nome);
    }
}
