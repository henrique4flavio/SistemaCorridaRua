package com.corridasjf.corrida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Organizador extends Usuario{

    @Id
    @GeneratedValue
    private Long id;

    public Organizador(Long id, String nome, String cpf, String rg, String dataNascimento, boolean sexo, String senha, String email, String celular, Long idUsuario){
        super(idUsuario, nome, cpf, rg, dataNascimento, sexo, senha, email, celular);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
