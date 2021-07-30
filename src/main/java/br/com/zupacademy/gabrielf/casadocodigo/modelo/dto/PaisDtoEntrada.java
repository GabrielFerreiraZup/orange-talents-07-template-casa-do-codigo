package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Pais;
import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueGeneric;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisDtoEntrada {

    @NotBlank
    @UniqueGeneric(domainClass = Pais.class,fieldName = "nome", message = "Nome do pais deve ser unico")
    private String nome;

    public String getNome() {
        return nome;
    }

    public PaisDtoEntrada(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais convertToPais(){
        return new Pais(this.nome);
    }
}
