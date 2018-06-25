package com.projeto.corrida.repository;

import com.projeto.corrida.model.Administrador;
import com.projeto.corrida.model.Organizador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizadorRepository extends CrudRepository<Organizador, Long> {
    boolean existsOrganizadorByEmailAndSenha(String var1, String var2);
    Organizador getOrganizadorByEmail(String var1);
}

