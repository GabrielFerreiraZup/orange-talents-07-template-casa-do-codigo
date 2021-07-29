package br.com.zupacademy.gabrielf.casadocodigo.repository;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {
}
