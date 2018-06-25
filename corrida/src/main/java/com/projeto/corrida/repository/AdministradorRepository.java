package com.projeto.corrida.repository;

import com.projeto.corrida.model.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    boolean existsAdministradorByEmailAndSenha(String email, String senha);
    Administrador getAdministradorByEmail(String var1);




}
