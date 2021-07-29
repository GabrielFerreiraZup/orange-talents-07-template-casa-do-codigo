package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;
import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueGeneric;
import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueNome;

import javax.validation.constraints.NotBlank;

public class CategoriaDtoEntrada {

    @NotBlank(message = "Nome deve ter um conteúdo")
    //@UniqueNome
    @UniqueGeneric(message = "Nome deve ser único",fieldName = "nome",domainClass = Categoria.class)
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
