package br.com.zupacademy.gabrielf.casadocodigo.modelo.dto;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Autor;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;
import br.com.zupacademy.gabrielf.casadocodigo.modelo.Livro;

import br.com.zupacademy.gabrielf.casadocodigo.validation.ExisteId;
import br.com.zupacademy.gabrielf.casadocodigo.validation.UniqueGeneric;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



public class LivroDtoEntrada {
    @NotBlank
    @UniqueGeneric(domainClass = Livro.class, fieldName = "titulo",message = "Titulo ja existente")
    private String titulo;
    @NotBlank
    private String resumo;
    private String sumario;
    @NotNull @Min(20)
    private Double preco;
    @NotBlank
    @UniqueGeneric(domainClass = Livro.class,fieldName = "lsbn",message = "Lsbn ja existente")
    private String lsbn;
    @Min(100)
    private int numero_paginas;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    @NotNull
    @ExisteId(domainClass = Autor.class,fieldName = "id",message = "Autor não existe no banco")
    private Long idAutor;
    @NotNull
    @ExisteId(domainClass = Categoria.class,fieldName = "id",message = "Categoria não existe no banco")
    private long idCategoria;

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

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setdataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LivroDtoEntrada(String titulo, String resumo, String sumario, Double preco, String lsbn, int numero_paginas,  Long idAutor, long idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.lsbn = lsbn;
        this.numero_paginas = numero_paginas;
        
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public Livro convertToCategoria(EntityManager em){
        Autor autor = em.find(Autor.class,idAutor);
        Categoria categoria = em.find(Categoria.class,idCategoria);
        Livro livro = new Livro(titulo,resumo,sumario,preco,numero_paginas,lsbn,dataLancamento,autor,categoria);
        return livro;
    }
}
