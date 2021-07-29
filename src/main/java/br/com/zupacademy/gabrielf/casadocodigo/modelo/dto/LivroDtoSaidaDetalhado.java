package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Livro;

public class LivroDtoSaidaDetalhado {

    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private String lsbn;
    public int numeroPaginas;

    private String nomeCategoria;

    private String nomeAutor;
    private String descricaoAutor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public String getLsbn() {
        return lsbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public LivroDtoSaidaDetalhado(Livro livro){
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.lsbn = livro.getLsbn();
        this.numeroPaginas = livro.getNumero_paginas();
        this.nomeCategoria = livro.getCategoria().getNome();
        this.nomeAutor = livro.getAutor().getNome();
        this.descricaoAutor = livro.getAutor().getDescricao();
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }
}
