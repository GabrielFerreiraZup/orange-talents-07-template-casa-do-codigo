package br.com.zupacademy.gabrielf.casadocodigo.modelo;

import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueEstadoName;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity

public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank

    private String nome;
    @NotNull
    @ManyToOne
    private Pais pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
    @Deprecated
    public Estado(){}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }



}
