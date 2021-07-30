package br.com.zupacademy.gabrielf.casadocodigo.repository;

import br.com.zupacademy.gabrielf.casadocodigo.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {
}
