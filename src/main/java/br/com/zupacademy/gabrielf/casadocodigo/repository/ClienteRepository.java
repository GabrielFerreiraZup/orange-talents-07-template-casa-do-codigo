package br.com.zupacademy.gabrielf.casadocodigo.repository;


import br.com.zupacademy.gabrielf.casadocodigo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
