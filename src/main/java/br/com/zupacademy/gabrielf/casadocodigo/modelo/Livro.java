package br.com.zupacademy.gabrielf.casadocodigo.modelo;

import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Size(max = 500)
    private String resumo;
    private String sumario;
    private Double preco;
    private int numero_paginas;

    private String lsbn;

    private LocalDate dataLancamento;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public Double getPreco() {
        return preco;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public String getLsbn() {
        return lsbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getSumario() {
        return sumario;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Deprecated
    public Livro(){}

    public Livro(String titulo, String resumo, String sumario, Double preco, int numero_paginas, String lsbn, LocalDate dataLancamento, Autor autor, Categoria categoria){
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numero_paginas = numero_paginas;
        this.lsbn = lsbn;
        this.dataLancamento = dataLancamento;
        this.autor = autor;
        this.categoria = categoria;
        //pega nome autor e coloca em um objeto
        //pega nome categoria e coloca em um objeto
    }



}
