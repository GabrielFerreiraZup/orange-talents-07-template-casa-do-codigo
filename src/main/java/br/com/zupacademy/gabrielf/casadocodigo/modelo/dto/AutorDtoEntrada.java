package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Autor;
import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueEmail;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AutorDtoEntrada {
    @NotBlank
    private String nome;
    @Email @NotBlank @UniqueEmail
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }




    public AutorDtoEntrada (String nome,String email,String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor convertToAutor(){

        return new Autor(this.nome,this.email,this.descricao);
    }

}
