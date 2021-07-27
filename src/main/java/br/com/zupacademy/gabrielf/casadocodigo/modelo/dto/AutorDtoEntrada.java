package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class AutorDtoEntrada {
    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank @Length(max = 400)
    private String descricao;




}
