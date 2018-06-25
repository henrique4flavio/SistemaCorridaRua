package com.projeto.corrida.repository;

import com.projeto.corrida.model.Atleta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaRepository extends CrudRepository<Atleta, Long> {
    boolean existsAtletaByEmailAndSenha(String var1, String var2);
    Atleta getAtletaByEmail(String var1);
}

