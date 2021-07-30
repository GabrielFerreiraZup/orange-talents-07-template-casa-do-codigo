package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueEstadoName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueEstadoName(message = "Estado não pode ter o mesmo nome no mesmo país")
public class EstadoDtoEntrada {
    @NotBlank
    //@UniqueInContext
    private String nome;
    @NotNull
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public EstadoDtoEntrada(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }


}
