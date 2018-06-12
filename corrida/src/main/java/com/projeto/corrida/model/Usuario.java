package com.projeto.corrida.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.MappedSuperclass;


@Data
@MappedSuperclass
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private String celular;

    public Usuario(Long id, String nome, String cpf, String senha, String email, String celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.celular = celular;

    }




}
