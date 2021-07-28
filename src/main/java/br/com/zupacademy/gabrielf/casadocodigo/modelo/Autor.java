package br.com.zupacademy.gabrielf.casadocodigo.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String email;
    @Size(max = 400)
    private String descricao;
    private LocalDateTime instante;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getInstante() {
        return instante;
    }
    @Deprecated
    public Autor(){}

    public Autor(String nome,String email,String descricao){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instante = LocalDateTime.now();

    }



}
