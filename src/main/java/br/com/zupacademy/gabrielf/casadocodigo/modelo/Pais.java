package br.com.zupacademy.gabrielf.casadocodigo.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    @Deprecated
    public Pais(){}

    public Pais(@JsonProperty("nome") String nome){
        this.nome = nome;
    }

}
