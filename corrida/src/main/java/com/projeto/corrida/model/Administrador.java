package com.projeto.corrida.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Administrador extends Usuario {

    public Administrador(Long id, String nome, String cpf, String senha, String email, String celular) {
        super(id, nome, cpf, senha, email, celular);
    }
}