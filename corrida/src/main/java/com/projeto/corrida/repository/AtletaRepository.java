package com.projeto.corrida.repository;

import com.projeto.corrida.model.Atleta;
import org.springframework.data.repository.CrudRepository;


public interface AtletaRepository extends CrudRepository<Atleta, Long> {
}
