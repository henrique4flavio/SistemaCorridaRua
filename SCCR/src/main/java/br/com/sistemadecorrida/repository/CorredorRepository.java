package br.com.sistemadecorrida.repository;

import br.com.sistemadecorrida.model.Corredor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorRepository extends CrudRepository<Corredor, Long> {
}
