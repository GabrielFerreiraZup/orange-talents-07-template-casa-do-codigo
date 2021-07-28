package br.com.zupacademy.gabrielf.casadocodigo.repository;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNome(String nome);



}
